package com.chenhao.service.impl;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.CommentDetail;
import com.chenhao.dao.entity.CommentRecord;
import com.chenhao.dao.entity.CommentRecordExample;
import com.chenhao.dao.mapper.CommentRecordMapper;
import com.chenhao.dto.request.AddCommentRequestDTO;
import com.chenhao.dto.response.CommentResponseDTO;
import com.chenhao.dto.response.CommentWebSocketContent;
import com.chenhao.dto.response.CommentWebSocketResponseDTO;
import com.chenhao.dto.response.ReplyResponseDTO;
import com.chenhao.service.ICommentService;
import com.chenhao.service.IRedisClientService;
import com.chenhao.service.IUserService;
import com.chenhao.service.Listenner.CommentEvent;
import com.chenhao.service.Listenner.CommentOrLikeListenerContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:评论服务
 * @author: chenhao
 * @date: 2021-10-8 14:24
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentRecordMapper commentMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRedisClientService redisClient;
    @Autowired
    private ApplicationContext context;
    /**
     * 未读评论的前缀
     */
    private static final String UN_READ_COMMENTS_PREFIX = "unReadComments|%s";
    /**
     * 未读点赞前缀
     */
    private static final String UN_READ_LIKES_PREFIX = "unReadLikes|%s";

    /**
     * 评论
     */
    public static final int COMMENT = 1;
    /**
     * 点赞
     */
    public static final int LIKE = 2;
    /**
     * 全部
     */
    private static final int ALL = 3;
    /**
     * 超过该阈值截取
     */
    private static final int ABBREVIATION_LENGTH = 10;

    @Override
    public List<CommentResponseDTO> getArticleComment(Long articleId) throws Exception {
        CommentRecordExample example = new CommentRecordExample();
        example.createCriteria().andArticleidEqualTo(articleId).andPidEqualTo(0L);
        example.setOrderByClause("commentDate desc");
        //先查出归属于文章的所有评论
        List<CommentRecord> commentRecords = commentMapper.selectByExampleWithBLOBs(example);
        List<CommentResponseDTO> result = new ArrayList<>();
        if (commentRecords != null && commentRecords.size() > 0) {
            //获取所有的一级评论
            commentRecords.forEach(p -> {
                CommentResponseDTO response = new CommentResponseDTO();
                response.setContent(p.getCommentcontent());
                response.setDate(p.getCommentdate());
                response.setOwnerId(p.getArticleid().toString());
                response.setId(p.getId());
                response.setFromId(p.getAnswererid());
                response.setLikeNum(p.getLikes());
                response.setIsLike(p.getLikes() > 0);
                response.setFromName(userService.getUserByUserId(p.getAnswererid()).getUsername());
                response.setFromAvatar(userService.getUserByUserId(p.getAnswererid()).getAvatarimgurl());
                //获取父级评论下的所有子评论
                CommentRecordExample reply = new CommentRecordExample();
                reply.createCriteria().andPidEqualTo(p.getId());
                List<CommentRecord> replyRecords = commentMapper.selectByExampleWithBLOBs(reply);
                reply.setOrderByClause("commentDate desc");
                if (replyRecords != null && replyRecords.size() > 0) {
                    List<ReplyResponseDTO> replyResult = new ArrayList<>();
                    replyRecords.forEach(t -> {
                        ReplyResponseDTO replyResponse = new ReplyResponseDTO();
                        replyResponse.setId(t.getId());
                        replyResponse.setCommentId(p.getId());
                        replyResponse.setDate(t.getCommentdate());
                        replyResponse.setFromId(t.getRespondentid());
                        replyResponse.setFromAvatar(userService.getUserByUserId(t.getRespondentid()).getAvatarimgurl());
                        replyResponse.setFromName(userService.getUserByUserId(t.getRespondentid()).getUsername());
                        replyResponse.setToAvatar(userService.getUserByUserId(t.getAnswererid()).getAvatarimgurl());
                        replyResponse.setToId(t.getAnswererid());
                        replyResponse.setToName(userService.getUserByUserId(t.getAnswererid()).getUsername());
                        replyResponse.setContent(t.getCommentcontent());
                        replyResult.add(replyResponse);
                    });
                    response.setReply(replyResult);
                }
                result.add(response);
            });
            return result;
        }
        return null;
    }

    @Override
    public Boolean addComment(AddCommentRequestDTO request) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CommentRecord record = new CommentRecord();
        record.setAnswererid(request.getFromId());
        record.setLikes(0);
        record.setCommentdate(format.format(new Date()));
        record.setArticleid(request.getArticleId());
        record.setRespondentid(request.getToId() == null ? 0 : request.getToId());
        record.setCommentcontent(request.getContent());
        record.setPid(request.getParentId() == null ? 0 : request.getParentId());
        int result = commentMapper.insertSelective(record);
        //缓存中增加未标识
        increaseLikeOrComment(record, 1);
        CommentOrLikeListenerContent build = new CommentOrLikeListenerContent.Builder().type(COMMENT).userId(request.getToId()).build();
        //推送评论变更监听
        context.publishEvent(new CommentEvent(build));
        return result > 0;
    }

    @Override
    public Boolean addLikes(Long commentId) throws Exception {
        CommentRecord record = commentMapper.selectByPrimaryKey(commentId);
        if (record == null) {
            throw new BusinessException(BusinessEnum.NO_COMMENT_EXIST);
        }
        record.setLikes(record.getLikes() + 1);
        int addLike = commentMapper.updateByPrimaryKey(record);
        //增加点赞未读标识
        increaseLikeOrComment(record, 2);
        CommentOrLikeListenerContent build = new CommentOrLikeListenerContent.Builder().type(LIKE).userId(record.getRespondentid()).build();
        //推送评论变更监听
        context.publishEvent(new CommentEvent(build));
        return addLike > 0;
    }

    @Override
    public int getUnReadInfo(Integer type, Integer userId) throws Exception {
        if (type == COMMENT) {
            return (Integer) redisClient.get(String.format(UN_READ_COMMENTS_PREFIX, userId));
        }
        if (type == LIKE) {
            return (Integer) redisClient.get(String.format(UN_READ_LIKES_PREFIX, userId));
        }
        return 0;
    }

    @Override
    public int getAllUnReadInfo(Integer userId) throws Exception {
        return getUnReadInfo(COMMENT, userId) + getUnReadInfo(LIKE, userId);
    }

    @Override
    public CommentWebSocketResponseDTO commentUnReadInfoForWebSocket(Integer type, Integer userId) throws Exception {
        CommentWebSocketResponseDTO response = new CommentWebSocketResponseDTO();
        if (null == userId || BusinessConstant.ILLEGAl_USER_ID == userId) {
            return response;
        }
        response.setAllUnReadCount(this.getAllUnReadInfo(userId));
        List<CommentWebSocketContent> commentContent=new ArrayList<>();
        List<CommentWebSocketContent> likeContent=new ArrayList<>();
        if (COMMENT == type || ALL == type) {
            Map<Object, Object> entries = redisClient.getRedisTemplate().opsForHash().entries(String.format(UN_READ_COMMENTS_PREFIX, userId));
            if (entries.isEmpty()) {
                response.setCommentsUnReadCount(0);
            } else {
                List<Long> ids = new ArrayList<>();
                entries.forEach((k, v) -> {
                    ids.add((Long) k);
                });
                List<CommentDetail> commentDetails = commentMapper.selectCommentDetail(ids);
                if (!commentDetails.isEmpty()) {
                    commentDetails.forEach(p -> {
                        CommentWebSocketContent item = new CommentWebSocketContent();
                        item.setFromName(p.getUserName());
                        item.setCommentAbbreviation(p.getCommentContent().length() > ABBREVIATION_LENGTH ? p.getCommentContent().substring(0, 10) : p.getCommentContent());
                        item.setArticleName(p.getArticleTitle());
                        commentContent.add(item);
                    });
                    response.setCommentsUnReadCount(commentContent.size());
                }
            }

        }
        if (LIKE == type || ALL == type) {
            Map<Object, Object> likes = redisClient.getRedisTemplate().opsForHash().entries(String.format(UN_READ_LIKES_PREFIX, userId));
            if(!likes.isEmpty()){
                List<Long> userIds=new ArrayList<>();
                likes.forEach((k,v)->{
                    userIds.add((Long) v);
                });
                List<CommentDetail> likeDetails = commentMapper.selectLikeDetail(userIds);
                if(!likeDetails.isEmpty()){
                    likeDetails.forEach(p->{
                        CommentWebSocketContent likeItem=new CommentWebSocketContent();
                        likeItem.setFromName(likeItem.getFromName());
                        likeItem.setArticleName(likeItem.getArticleName());
                        likeContent.add(likeItem);
                    });
                    response.setLikesUnReadCount(likeContent.size());
                }
            }else {
                response.setLikesUnReadCount(0);
            }
        }
        response.setComments(commentContent);
        response.setLikes(likeContent);
        return response;
    }

    /**
     * 新增redis中的点赞或者评论数
     *
     * @param record
     */
    private void increaseLikeOrComment(CommentRecord record, int type) {
        switch (type) {
            case 1:
                //新增未读评论+1
                redisClient.getRedisTemplate().opsForValue().increment(String.format(UN_READ_COMMENTS_PREFIX, record.getRespondentid()));
                redisClient.getRedisTemplate().opsForHash().put(String.format(UN_READ_COMMENTS_PREFIX, record.getRespondentid()), record.getId(), record.getCommentcontent());
                break;
            case 2:
                //新增未读点赞+1
                redisClient.getRedisTemplate().opsForValue().increment(String.format(UN_READ_LIKES_PREFIX, record.getRespondentid()));
                redisClient.getRedisTemplate().opsForHash().put(String.format(UN_READ_LIKES_PREFIX, record.getRespondentid()), record.getArticleid(), record.getAnswererid());
                break;
            default:
        }
    }
}
