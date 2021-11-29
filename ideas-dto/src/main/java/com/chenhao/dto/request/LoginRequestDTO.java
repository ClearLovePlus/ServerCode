package com.chenhao.dto.request;

import com.chenhao.dto.annotations.NotNull;
import lombok.Data;

import java.util.Map;

/**
 * @description:登录请求实体
 * @author: chenhao
 * @date: 2021-6-1 13:26
 */
@Data
public class LoginRequestDTO {
    @NotNull(type = NotNull.Types.Mobile,required = true)
    private String phone;
    @NotNull(required = true)
    private String authCode;
    @NotNull(required = true)
    private String password;
    private Map<String,String> extraInfo;
}
