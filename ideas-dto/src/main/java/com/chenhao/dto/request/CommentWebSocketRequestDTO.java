package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-15 10:27
 */
@Data
public class CommentWebSocketRequestDTO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 是点赞还是评论
     * 1.评论
     * 2.点赞
     */
    private Integer type;
}
