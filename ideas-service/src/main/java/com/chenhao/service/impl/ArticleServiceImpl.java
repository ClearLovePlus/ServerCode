package com.chenhao.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.constants.RedisKeyConstants;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.Article;
import com.chenhao.dao.entity.ArticleExample;
import com.chenhao.dao.entity.Categories;
import com.chenhao.dao.mapper.ArticleMapper;
import com.chenhao.dto.request.ArticleRequestDTO;
import com.chenhao.dto.response.ArticleForSearchResponseDTO;
import com.chenhao.dto.response.ArticleResponse;
import com.chenhao.dto.response.TokenResponseDTO;
import com.chenhao.service.IArticleService;
import com.chenhao.service.ICategoriesService;
import com.chenhao.service.IRedisClientService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
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
@DependsOn({"categoriesService","articleMapper","redisClient"})
public class ArticleServiceImpl implements IArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    private static final int ZERO = 0;
    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private IRedisClientService redisClient;
    @Value("${blog.url}")
    private String url;
    @Autowired
    private ICategoriesService categoriesService;

    @Override
    public Boolean validatePermission(String token, Long articleId) throws Exception {
        String o = (String) redisClient.get(String.format(RedisKeyConstants.TOKEN_PREFIX, token));
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
        if (userId == null || userId == ZERO) {
            articleExample.createCriteria().andIdGreaterThan(0).andIsActiveEqualTo(1);
        } else {
            articleExample.createCriteria().andAuthoridEqualTo(userId).andIsActiveEqualTo(1);
        }
        articleExample.setOrderByClause("publishDate desc");
        RowBounds rowBounds = new RowBounds((currentPage - 1) * 5, 5);
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
        articleExample.createCriteria().andArticleidEqualTo(articleId).andIsActiveEqualTo(1);
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
            request.setArticleurl(url + request.getArticleid());
            request.setPublishdate(format.format(new Date()));
            request.setUpdatedate(format.format(new Date()));
            BeanUtils.copyProperties(request, newArticle);
            newArticle.setAuthorid(request.getAuthorId());
            if (checkCategory(request.getCategoryName(), request.getAuthorId())) {
                newArticle.setArticlecategories(request.getCategoryName());
            } else {
                String defaultCategory = categoriesService.getDefault().getCategoryname();
                newArticle.setArticlecategories(defaultCategory);
                logger.info("原来文章标签:{}不存在,替换成默认标签:{}", request.getCategoryName(), defaultCategory);
            }
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
        article.setArticlecategories(categoriesService.getDefault().getCategoryname());
        //文章分类问题暂时修改
//        if (!article.getArticlecategories().equals(request.getCategoryName()) && !StringUtils.isEmpty(request.getCategoryName())) {
//            if (checkCategory(request.getCategoryName(), request.getAuthorId())) {
//                logger.info("文章标签由{}替换成{}",article.getArticlecategories(),request.getCategoryName());
//                article.setArticlecategories(request.getCategoryName());
//            }
//        }
        return articleMapper.updateByPrimaryKeyWithBLOBs(article) > 0;
    }

    @Override
    public Long articles(Integer userId) throws Exception {
        return articleMapper.countByUserId(userId);
    }

    @Override
    public List<ArticleForSearchResponseDTO> getAllArticlePrefix() {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andIsActiveEqualTo(1);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        List<ArticleForSearchResponseDTO> result = new ArrayList<>(articles.size());
        articles.forEach(p -> {
            ArticleForSearchResponseDTO response = new ArticleForSearchResponseDTO();
            response.setArticleUrl(url + p.getArticleid());
            response.setValue(p.getArticletitle());
            result.add(response);
        });
        return result;
    }

    /**
     * 判断标签是否合法
     *
     * @param name
     * @param userId
     * @return
     */
    private boolean checkCategory(String name, Integer userId) {
        try {
            Categories categoryByUserIdAndName = categoriesService.getCategoryByUserIdAndName(userId, name);
            return categoryByUserIdAndName != null;
        } catch (Exception e) {
            logger.error("判断标签是否合法异常:{}", e.getMessage(), e);
            return true;
        }
    }
}
