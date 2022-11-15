package com.chenhao.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-15 10:40
 */
@Data
public class CommentWebSocketResponseDTO {
    private Integer commentsUnReadCount;
    private Integer likesUnReadCount;
    private Integer allUnReadCount;
    private List<CommentWebSocketContent> likes;
    private List<CommentWebSocketContent> comments;
}
