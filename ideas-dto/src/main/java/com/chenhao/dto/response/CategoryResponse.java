package com.chenhao.dto.response;

/**
 * @description: 分类标签返回值
 * @author: chenhao
 * @date: 2021-11-22 15:25
 */
public class CategoryResponse {
    private String categoryName;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "categoryName='" + categoryName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
