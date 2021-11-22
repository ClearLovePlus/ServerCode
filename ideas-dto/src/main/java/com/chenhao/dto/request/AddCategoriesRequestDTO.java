package com.chenhao.dto.request;

import io.swagger.annotations.ApiModel;

/**
 * @description: 新增分类标签，每个人有自己自定义的分类标签
 * @author: chenhao
 * @date: 2021-11-22 14:28
 */
@ApiModel(value = "AddCategoriesRequestDTO",description = "分类标签的请求实体")
public class AddCategoriesRequestDTO {
    private String categoryName;
    private Integer userId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AddCategoriesRequestDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
