package com.chenhao.dto.response;


import lombok.Data;

/**
 * @description:用户信息返回实体
 * @author: chenhao
 * @date: 2021-10-15 13:43
 */
@Data
public class UserInfoResponse {
    private Integer userId;
    private Integer sex;
    private String userName;
    private String trueName;
    private String description;
    private String avatarUrl;
    private String phone;
    private String email;
}
