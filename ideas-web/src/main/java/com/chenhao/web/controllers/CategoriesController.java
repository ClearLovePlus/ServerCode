package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.AddCategoriesRequestDTO;
import com.chenhao.dto.response.CategoryResponse;
import com.chenhao.service.ICategoriesService;
import com.chenhao.web.annotions.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 标签相关接口
 * @author: chenhao
 * @date: 2021-11-22 14:55
 */
@RestController
@RequestMapping(value = "category")
@Api(tags = {"文章标签服务"}, value = "文章标签服务")
public class CategoriesController {
    @Autowired
    private ICategoriesService categoriesService;

    @ResponseBody
    @Log
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation("个人新增文章分类")
    BaseResponse<Boolean> addCategories(@RequestBody List<AddCategoriesRequestDTO> request) throws Exception {
        return new BaseResponse<>(categoriesService.addCategories(request));
    }

    @ResponseBody
    @Log
    @RequestMapping(value = "getCategories", method = RequestMethod.GET)
    @ApiOperation("获取对应用户的所有文章标签")
    BaseResponse<List<CategoryResponse>> getCategoryBelongToUser(@RequestParam("userId") Integer userId) throws Exception{
       return new BaseResponse<>(categoriesService.getCategoriesBelongToTheUser(userId));
    }
}
