package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-10-8 15:08
 */
@Data
public class ReplyResponseDTO {
    private Long id;
    private Long commentId;
    private Integer fromId;
    private String fromName;
    private String fromAvatar;
    private String toName;
    private Integer toId;
    private String content;
    private String date;
    private String toAvatar;
}
