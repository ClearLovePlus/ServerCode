package com.chenhao.dto.request;

import lombok.Data;

import java.util.Map;

/**
 * @description:登录请求实体
 * @author: chenhao
 * @date: 2021-6-1 13:26
 */
@Data
public class LoginRequestDTO {
    private String phone;
    private String authCode;
    private String password;
    private Map<String,String> extraInfo;
}
