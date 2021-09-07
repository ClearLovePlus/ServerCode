package com.chenhao.common.constants;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-20 9:54
 */
public class RedisKeyConstants {
    /**
     * 注册验证码redis前缀
     */
    public static final String REGISTER_PREFIX = "register:code:%s";

    /**
     * 登录时候的验证码
     */
    public static final String LOGIN_PREFIX="login:code:%s";
}
