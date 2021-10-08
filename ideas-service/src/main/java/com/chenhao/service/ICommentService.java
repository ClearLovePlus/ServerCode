package com.chenhao.service;

import com.chenhao.dto.request.AddCommentRequestDTO;
import com.chenhao.dto.response.CommentResponseDTO;

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
}
