package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:评论添加请求实体
 * @author: chenhao
 * @date: 2021-10-8 16:05
 */
@Data
public class AddCommentRequestDTO {
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论人id
     */
    private Integer fromId;
    /**
     * 被评论人的id，如果不是回复的评论，那么就没有这个值
     */
    private Integer toId;
    /**
     * 被评论的评论的id，如果不是回复的评论，那么就没有这个值
     */
    private Long parentId;
}
