package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:修改用户信息
 * @author: chenhao
 * @date: 2021-10-15 11:21
 */
@Data
public class ChangeRequestDTO {
    private Integer userId;
    private String email;
    private String userName;
    private Integer sex;
    private String description;
    private String avatarUrl;
}
