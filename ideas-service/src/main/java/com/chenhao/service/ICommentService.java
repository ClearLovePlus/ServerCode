package com.chenhao.service;

import com.chenhao.dto.request.AddCommentRequestDTO;
import com.chenhao.dto.response.CommentResponseDTO;
import com.chenhao.dto.response.CommentWebSocketResponseDTO;

import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-10-8 14:01
 */
public interface ICommentService {
    /**
     * 获取改文章的所有的评论
     * @param articleId
     * @return
     * @throws Exception
     */
    List<CommentResponseDTO> getArticleComment(Long articleId) throws Exception;

    /**
     * 添加评论
     * @param request
     * @return
     * @throws Exception
     */
    Boolean addComment(AddCommentRequestDTO request) throws Exception;

    /**
     * 给评论点赞
     * @param commentId
     * @return
     * @throws Exception
     */
    Boolean addLikes(Long commentId) throws Exception;

    /**
     * 获取未读的点赞或者评论
     * 1：获取未读评论
     * 2：获取未读点赞
     * @param type
     * @return
     * @throws Exception
     */
    int getUnReadInfo(Integer type,Integer userId) throws Exception;

    /**
     * 获取所有未读信息
     * @param userId
     * @return
     * @throws Exception
     */
    int getAllUnReadInfo(Integer userId) throws Exception;

    /**
     * 为websocket写的获取未读信息接口
     * @param type
     * @param userId
     * @return
     * @throws Exception
     */
    CommentWebSocketResponseDTO commentUnReadInfoForWebSocket(Integer type,Integer userId) throws Exception;
}
