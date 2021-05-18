package com.chenhao.web.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:权限控制模块注解
 * @author: chenhao
 * @date: 2021-1-7 15:27
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    /**
     * 角色权限控制
     * @return
     */
    String role() default "";

    /**
     * 是否需要登录态
     * @return
     */
    boolean needLogin() default false;
}
