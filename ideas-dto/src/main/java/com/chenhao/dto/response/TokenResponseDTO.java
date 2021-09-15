package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description: token返回实体
 * @author: chenhao
 * @date: 2021-9-15 13:34
 */
@Data
public class TokenResponseDTO {
    private String token;
    private Integer userId;
}
