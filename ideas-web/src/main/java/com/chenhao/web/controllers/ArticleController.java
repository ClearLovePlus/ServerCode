package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.ArticleRequestDTO;
import com.chenhao.dto.response.ArticleResponse;
import com.chenhao.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-15 14:54
 */
@RestController
@RequestMapping("article")
@Api(tags = {"文章服务"}, value = "文章服务")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation("查询所有文章")
    @RequestMapping(value = "getAllUserArticle", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<List<ArticleResponse>> getAllUserArticle(@RequestParam(value = "userId", required = true) Integer userId) throws Exception {
        BaseResponse<List<ArticleResponse>> response = new BaseResponse<>();
        List<ArticleResponse> allArticle = articleService.getAllArticle(userId);
        response.setData(allArticle);
        return response;
    }

    @ApiOperation("查询单个文章")
    @RequestMapping(value = "getArticleByArticleId", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<ArticleResponse> getArticleByArticleId(@RequestParam(value = "articleId", required = true) Long articleId) throws Exception {
        BaseResponse<ArticleResponse> response = new BaseResponse<>();
        ArticleResponse article = articleService.getArticleByArticleId(articleId);
        response.setData(article);
        return response;
    }

    @ApiOperation("发布文章(新增或者修改文章)")
    @RequestMapping(value = "pulishArticle", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse<Boolean> publishArticle(@RequestBody ArticleRequestDTO requestDTO) throws Exception {
        Boolean aBoolean = articleService.editArticle(requestDTO);
        return new BaseResponse<>(aBoolean);
    }
}
