package com.chenhao.dto.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-11-22 16:09
 */
public class CategoryArticleRelationAddRequestDTO {
    @ApiModelProperty(value = "文章数据库主键id")
    private Integer articleIndexId;
    @ApiModelProperty(value = "标签数据库主键id")
    private Integer categoryId;

    public Integer getArticleIndexId() {
        return articleIndexId;
    }

    public void setArticleIndexId(Integer articleIndexId) {
        this.articleIndexId = articleIndexId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CategoryArticleRelationAddRequestDTO{" +
                "articleIndexId=" + articleIndexId +
                ", categoryId=" + categoryId +
                '}';
    }
}
