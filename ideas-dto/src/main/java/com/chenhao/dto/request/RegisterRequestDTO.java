package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-18 15:04
 */
@Data
public class RegisterRequestDTO {
    private String authCode;
    private String phoneNum;
    private String userName;
    private String password;
}
