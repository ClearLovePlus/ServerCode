package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-19 13:33
 */

public class RegisterResponseDTO {
    private Integer userId;
    private String userName;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
