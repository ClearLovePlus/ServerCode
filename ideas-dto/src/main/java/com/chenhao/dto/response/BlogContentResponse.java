package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-9 16:38
 */
@Data
public class BlogContentResponse {
    private String  index;
    private String textContent;
    private String authorName;
    private String updateDate;
    private Long id;
    private String title;
    private String createDate;
}
