package com.chenhao.service.impl;

import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.CommentRecord;
import com.chenhao.dao.entity.CommentRecordExample;
import com.chenhao.dao.mapper.CommentRecordMapper;
import com.chenhao.dto.request.AddCommentRequestDTO;
import com.chenhao.dto.response.CommentResponseDTO;
import com.chenhao.dto.response.ReplyResponseDTO;
import com.chenhao.service.ICommentService;
import com.chenhao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Override
    public List<CommentResponseDTO> getArticleComment(Long articleId) throws Exception {
        CommentRecordExample example=new CommentRecordExample();
        example.createCriteria().andArticleidEqualTo(articleId).andPidEqualTo(0L);
        //先查出归属于文章的所有评论
        List<CommentRecord> commentRecords = commentMapper.selectByExampleWithBLOBs(example);
        List<CommentResponseDTO> result=new ArrayList<>();
        if(commentRecords!=null&&commentRecords.size()>0){
            //获取所有的一级评论
            commentRecords.forEach(p->{
                CommentResponseDTO response=new CommentResponseDTO();
                response.setContent(p.getCommentcontent());
                response.setDate(p.getCommentdate());
                response.setOwnerId(p.getArticleid().toString());
                response.setId(p.getId());
                response.setFromId(p.getAnswererid());
                response.setLikeNum(p.getLikes());
                response.setIsLike(p.getLikes()>0);
                response.setFromName(userService.getUserByUserId(p.getAnswererid()).getUsername());
                response.setFromAvatar(userService.getUserByUserId(p.getAnswererid()).getAvatarimgurl());
                //获取父级评论下的所有子评论
                CommentRecordExample reply=new CommentRecordExample();
                reply.createCriteria().andPidEqualTo(p.getId());
                List<CommentRecord> replyRecords = commentMapper.selectByExampleWithBLOBs(reply);
                if(replyRecords!=null&&replyRecords.size()>0){
                    List<ReplyResponseDTO> replyResult=new ArrayList<>();
                    replyRecords.forEach(t->{
                        ReplyResponseDTO replyResponse=new ReplyResponseDTO();
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
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CommentRecord record=new CommentRecord();
        record.setAnswererid(request.getFromId());
        record.setLikes(0);
        record.setCommentdate(format.format(new Date()));
        record.setArticleid(request.getArticleId());
        record.setRespondentid(request.getToId()==null?0:request.getToId());
        record.setCommentcontent(request.getContent());
        record.setPid(request.getParentId()==null?0:request.getParentId());
        return  commentMapper.insertSelective(record)>0;
    }

    @Override
    public Boolean addLikes(Long commentId) throws Exception {
        CommentRecord record = commentMapper.selectByPrimaryKey(commentId);
        if(record==null){
            throw new BusinessException(BusinessEnum.NO_COMMENT_EXIST);
        }
        record.setLikes(record.getLikes()+1);
        return commentMapper.updateByPrimaryKey(record)>0;
    }
}
