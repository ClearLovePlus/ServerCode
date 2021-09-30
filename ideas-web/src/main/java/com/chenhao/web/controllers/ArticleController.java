package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.ArticleRequestDTO;
import com.chenhao.dto.response.ArticleForSearchResponseDTO;
import com.chenhao.dto.response.ArticleResponse;
import com.chenhao.dto.response.PageResponse;
import com.chenhao.service.IArticleService;
import com.chenhao.web.annotions.Log;
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

    @Log
    @ApiOperation("查询所有文章")
    @RequestMapping(value = "getAllUserArticle", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<PageResponse<List<ArticleResponse>>> getAllUserArticle(@RequestParam(value = "userId", required = false) Integer userId, @RequestParam(value = "currentPage", required = true)Integer currentPage) throws Exception {
        BaseResponse<PageResponse<List<ArticleResponse>>> response = new BaseResponse<>();
        List<ArticleResponse> allArticle = articleService.getAllArticle(userId,currentPage);
        PageResponse pageResponse=new PageResponse();
        pageResponse.setCurrentPage(currentPage);
        pageResponse.setTotal(articleService.articles(userId));
        pageResponse.setData(allArticle);
        pageResponse.setPageSize(5);
        response.setData(pageResponse);
        return response;
    }

    @Log
    @ApiOperation("查询单个文章")
    @RequestMapping(value = "getArticleByArticleId/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<ArticleResponse> getArticleByArticleId(@PathVariable(value = "articleId", required = true) Long articleId) throws Exception {
        BaseResponse<ArticleResponse> response = new BaseResponse<>();
        ArticleResponse article = articleService.getArticleByArticleId(articleId);
        response.setData(article);
        return response;
    }

    @Log
    @ApiOperation("发布文章(新增或者修改文章)")
    @RequestMapping(value = "publishArticle", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse<Boolean> publishArticle(@RequestBody ArticleRequestDTO requestDTO) throws Exception {
        Boolean aBoolean = articleService.editArticle(requestDTO);
        return new BaseResponse<>(aBoolean);
    }

    /**
     * 数据量小的情况下可以前端去做过滤，咱们将数据全部返回给前端，但是数据量多的情况下一定不要这么做
     * @return
     */
    @Log
    @ApiOperation("获取所有文章简略")
    @RequestMapping(value = "getAllArticlePrefix", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<List<ArticleForSearchResponseDTO>> getArticlePrefix(){
        return new BaseResponse<>(articleService.getAllArticlePrefix());
    }
}
