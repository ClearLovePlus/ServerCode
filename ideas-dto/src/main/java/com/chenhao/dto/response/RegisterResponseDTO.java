package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-19 13:33
 */
@Data
public class RegisterResponseDTO {
    private Integer userId;
    private String userName;
    private String token;
}
