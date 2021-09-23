package com.chenhao.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.constants.RedisKeyConstants;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.Article;
import com.chenhao.dao.entity.ArticleExample;
import com.chenhao.dao.mapper.ArticleMapper;
import com.chenhao.dto.request.ArticleRequestDTO;
import com.chenhao.dto.response.ArticleResponse;
import com.chenhao.dto.response.TokenResponseDTO;
import com.chenhao.service.IArticleService;
import com.chenhao.service.IRedisClientService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-15 13:25
 */
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
    private static final int ZERO = 0;
    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private IRedisClientService redisClient;

    @Override
    public Boolean validatePermission(String token, Long articleId) throws Exception {
        String o =(String) redisClient.get(String.format(RedisKeyConstants.TOKEN_PREFIX, token));
        TokenResponseDTO tokenForUser = JSON.parseObject((String) redisClient.get(String.format(RedisKeyConstants.TOKEN_PREFIX, token)), TokenResponseDTO.class);
        if (tokenForUser == null) {
            throw new BusinessException(BusinessEnum.NO_PERMISSION_TO_WRITE);
        }
        ArticleResponse article = this.getArticleByArticleId(articleId);
        if (article == null) {
            throw new BusinessException(BusinessEnum.NO_PERMISSION_TO_WRITE);
        }
        return article.getAuthorId() == (long) tokenForUser.getUserId();
    }

    @Override
    public List<ArticleResponse> getAllArticle(Integer userId, Integer currentPage) throws Exception {
        ArticleExample articleExample = new ArticleExample();
        if (userId == null||userId==ZERO) {
            articleExample.createCriteria().andIdGreaterThan(0);
        } else {
            articleExample.createCriteria().andAuthoridEqualTo(userId);
        }
        articleExample.setOrderByClause("publishDate desc");
        RowBounds rowBounds = new RowBounds((currentPage-1)*5, 5);
        List<Article> articles = articleMapper.selectByExampleWithRowbounds(articleExample, rowBounds);
        if (CollectionUtils.isEmpty(articles)) {
            return null;
        }
        List<ArticleResponse> result = new ArrayList<>(articles.size());
        articles.forEach(p -> {
            ArticleResponse response = new ArticleResponse();
            response.setArticleId(p.getArticleid());
            response.setContent(p.getArticlecontent());
            response.setArticleUrl(p.getArticleurl());
            response.setAuthorName(p.getAuthor());
            response.setCreatDate(p.getPublishdate());
            response.setId(p.getId());
            response.setTitle(p.getArticletitle());
            response.setDescription(p.getArticletabloid());
            result.add(response);
        });
        return result;
    }

    @Override
    public ArticleResponse getArticleByArticleId(Long articleId) throws Exception {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andArticleidEqualTo(articleId);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        if (CollectionUtils.isEmpty(articles)) {
            return null;
        }
        ArticleResponse response = new ArticleResponse();
        response.setArticleId(articles.get(0).getArticleid());
        response.setContent(articles.get(0).getArticlecontent());
        response.setArticleUrl(articles.get(0).getArticleurl());
        response.setAuthorName(articles.get(0).getAuthor());
        response.setCreatDate(articles.get(0).getPublishdate());
        response.setId(articles.get(0).getId());
        response.setTitle(articles.get(0).getArticletitle());
        response.setDescription(articles.get(0).getArticletabloid());
        response.setAuthorId(articles.get(0).getAuthorid().longValue());
        return response;
    }

    @Override
    public Boolean createArticle(ArticleRequestDTO request) throws Exception {
        return null;
    }

    @Override
    public Boolean editArticle(ArticleRequestDTO request) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (request.getId() == null || request.getId() == ZERO) {
            Article newArticle = new Article();
            request.setArticleid(System.currentTimeMillis());
            request.setArticleurl("http://localhost:8080/getArticleByArticleId/"+request.getArticleid());
            request.setPublishdate(format.format(new Date()));
            request.setUpdatedate(format.format(new Date()));
            BeanUtils.copyProperties(request, newArticle);
            return articleMapper.insertSelective(newArticle) > 0;
        }
        if (!validatePermission(request.getToken(), request.getArticleid())) {
            throw new BusinessException(BusinessEnum.NO_PERMISSION_TO_WRITE);
        }
        Article article = articleMapper.selectByPrimaryKey(request.getId());
        if (article == null) {
            throw new BusinessException(BusinessEnum.NO_ARTICLE_EXIST);
        }
        article.setArticlecontent(request.getArticlecontent());
        article.setArticletitle(request.getArticletitle());
        article.setArticletabloid(request.getArticletabloid());
        article.setUpdatedate(format.format(new Date()));
        return articleMapper.updateByPrimaryKeyWithBLOBs(article) > 0;
    }

    @Override
    public Long articles(Integer userId) throws Exception {
        return articleMapper.countByUserId(userId);
    }
}
