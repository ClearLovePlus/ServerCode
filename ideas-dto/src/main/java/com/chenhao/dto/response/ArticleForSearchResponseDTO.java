package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:为搜索框定制的文章实体
 * @author: chenhao
 * @date: 2021-9-30 15:51
 */
@Data
public class ArticleForSearchResponseDTO{
    private String value;
    private String articleUrl;
}
