package com.chenhao.service;

import com.chenhao.dto.request.ArticleRequestDTO;
import com.chenhao.dto.response.ArticleResponse;

import java.util.List;

/**
 * @description文章服务
 * @author: chenhao
 * @date: 2021-9-15 11:04
 */
public interface IArticleService {
    /**
     * 判断是否有权限编辑article
     * @param token
     * @return
     * @throws Exception
     */
     Boolean validatePermission(String token,Long articleId) throws Exception;

    /**
     * 获取所有文章
     * @return
     * @throws Exception
     */
     List<ArticleResponse> getAllArticle(Integer userId) throws Exception;

    /**
     * 通过文章id获取文章内容
     * @param articleId
     * @return
     * @throws Exception
     */
     ArticleResponse getArticleByArticleId(Long articleId) throws Exception;

    /**
     * 新增文章接口
     * @param request
     * @return
     * @throws Exception
     */
     Boolean createArticle(ArticleRequestDTO request) throws Exception;

    /**
     * 修改文章接口
     * @param request
     * @return
     * @throws Exception
     */
     Boolean editArticle(ArticleRequestDTO request) throws Exception;
}
