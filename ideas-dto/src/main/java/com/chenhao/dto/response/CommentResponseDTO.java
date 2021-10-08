package com.chenhao.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @description:评论返回实体
 * @author: chenhao
 * @date: 2021-10-8 14:03
 */
@Data
public class CommentResponseDTO {
    /**
     * 评论编号
     */
    private Long id;
    /**
     * 评论日期
     */
    private String date;
    /**
     * 文章id
     */
    private String ownerId;
    /**
     * 评论者userId
     */
    private Integer fromId;
    /**
     * 评论者用户名
     */
    private String fromName;
    /**
     * 评论者头像
     */
    private String fromAvatar;
    private Integer likeNum;
    private String content;

    /**
     * 该评论下的所有回复
     */
    private List<ReplyResponseDTO> reply;
}
