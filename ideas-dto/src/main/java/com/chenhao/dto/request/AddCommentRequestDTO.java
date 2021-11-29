package com.chenhao.dto.request;

import com.chenhao.dto.annotations.NotNull;
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
    @NotNull(type = NotNull.Types.Long,required = true)
    private Long articleId;
    /**
     * 评论内容
     */
    @NotNull(type = NotNull.Types.STRING,required = true)
    private String content;
    /**
     * 评论人id
     */
    @NotNull(type = NotNull.Types.INT,required = true)
    private Integer fromId;
    /**
     * 被评论人的id，如果不是回复的评论，那么就没有这个值
     */
    @NotNull(type = NotNull.Types.INT,required = true)
    private Integer toId;
    /**
     * 被评论的评论的id，如果不是回复的评论，那么就没有这个值
     */
    @NotNull(type = NotNull.Types.Long,required = true)
    private Long parentId;
}
