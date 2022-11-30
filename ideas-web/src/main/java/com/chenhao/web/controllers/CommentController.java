package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.AddCommentRequestDTO;
import com.chenhao.dto.response.CommentResponseDTO;
import com.chenhao.service.ICommentService;
import com.chenhao.web.annotions.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-10-8 15:33
 */
@RestController
@RequestMapping("comment")
@Api(tags = {"评论服务"},value = "评论服务")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = "allComments",method = RequestMethod.GET)
    @Log
    @ResponseBody
    @ApiOperation("查询文章下的所有评论")
    BaseResponse<List<CommentResponseDTO>> getArticleComments(@RequestParam(value = "articleId") Long articleId) throws Exception{
        return new BaseResponse<>(commentService.getArticleComment(articleId));
    }

    @RequestMapping(value = "addComments",method = RequestMethod.POST)
    @Log
    @ResponseBody
    @ApiOperation("添加评论")
    BaseResponse<Boolean> AddComments(@RequestBody AddCommentRequestDTO request) throws Exception{
        return new BaseResponse<>(commentService.addComment(request));
    }

    @RequestMapping(value = "addLikes",method = RequestMethod.GET)
    @Log
    @ResponseBody
    @ApiOperation("点赞")
    BaseResponse<Boolean> addLikes(@RequestParam(value = "commentId") Long commentId) throws Exception{
        return new BaseResponse<>(commentService.addLikes(commentId));
    }

    @RequestMapping(value = "getUnReadInfo",method = RequestMethod.GET)
    @Log
    @ResponseBody
    @ApiOperation("获取未读信息")
    BaseResponse<Integer> getUnReadInfo(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "type") Integer type) throws Exception{
        return new BaseResponse<>(commentService.getUnReadInfo(type,userId));
    }

    @RequestMapping(value = "getAllUnReadInfo",method = RequestMethod.GET)
    @Log
    @ResponseBody
    @ApiOperation("获取所有未读信息")
    BaseResponse<Integer> getUnAllReadInfo(@RequestParam(value = "userId") Integer userId) throws Exception{
        return new BaseResponse<>(commentService.getAllUnReadInfo(userId));
    }
}
