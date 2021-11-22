package com.chenhao.service;

import com.chenhao.dao.entity.Categories;
import com.chenhao.dto.request.AddCategoriesRequestDTO;
import com.chenhao.dto.request.CategoryArticleRelationAddRequestDTO;
import com.chenhao.dto.response.CategoryResponse;

import java.util.List;

/**
 * @description: 文章分类接口
 * @author: chenhao
 * @date: 2021-11-22 14:23
 */
public interface ICategoriesService {

    /**
     * 新增分类标签
     * @param list
     * @return
     * @throws Exception
     */
    Boolean addCategories(List<AddCategoriesRequestDTO> list) throws Exception;

    /**
     * 获取该用户的所有文章标签
     * @param userId
     * @return
     * @throws Exception
     */
    List<CategoryResponse> getCategoriesBelongToTheUser(Integer userId)  throws Exception;

    /**
     * 文章和标签关系表
     * @param categoryId
     * @param articleId
     * @param userId
     * @return
     * @throws Exception
     */
    Boolean addCategoryArticleRelation(Integer categoryId,Integer articleId,Integer userId) throws Exception;

    /**
     * 标签名和userId查询标签信息
     * @param userId
     * @param name
     * @return
     * @throws Exception
     */
    Categories getCategoryByUserIdAndName(Integer userId,String name) throws Exception;

    /**
     * 返回默认的tag
     * @return
     * @throws Exception
     */
    Categories getDefault() throws Exception;
}
