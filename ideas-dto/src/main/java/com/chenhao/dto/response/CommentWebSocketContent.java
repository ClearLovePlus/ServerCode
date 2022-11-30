package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-15 10:46
 */
@Data
public class CommentWebSocketContent {
    private String  fromName;
    private String  articleName;
    private String  commentAbbreviation;
}
