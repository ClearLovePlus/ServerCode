package com.chenhao.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-15 11:09
 */
@ApiModel
@Data
public class ArticleResponse {
    @ApiModelProperty(value = "文章id")
    private Integer id;
    @ApiModelProperty(value = "作者id")
    private Long authorId;
    @ApiModelProperty(value = "文章标题")
    private String title;
    @ApiModelProperty(value = "文章摘要")
    private String description;
    @ApiModelProperty(value = "日期")
    private String creatDate;
    @ApiModelProperty(value = "文章内容")
    private String content;
    @ApiModelProperty(value = "文章id")
    private Long articleId;
    @ApiModelProperty(value = "文章链接")
    private String articleUrl;
    @ApiModelProperty(value = "作者姓名")
    private String authorName;
}
