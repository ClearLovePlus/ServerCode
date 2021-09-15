package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-15 11:27
 */
@Data
public class ArticleRequestDTO {
    private Integer id;

    private Long articleid;

    private String author;

    private String originalauthor;

    private String articletitle;

    private String articletags;

    private String articletype;

    private String articlecategories;

    private String publishdate;

    private String updatedate;

    private String articleurl;

    private Integer likes;

    private Long lastarticleid;

    private Long nextarticleid;

    private Integer isActive;

    private String articlecontent;

    private String articletabloid;
    private String token;
}
