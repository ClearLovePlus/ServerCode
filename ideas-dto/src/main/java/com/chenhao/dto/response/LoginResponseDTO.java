package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:登录返回实体
 * @author: chenhao
 * @date: 2021-6-1 13:28
 */
@Data
public class LoginResponseDTO {
    private String userName;
    private Integer userId;
    private String token;
    private String avatar;

}
