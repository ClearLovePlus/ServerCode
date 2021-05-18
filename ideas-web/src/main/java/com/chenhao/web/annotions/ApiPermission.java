package com.chenhao.web.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:api访问权限控制，加上此注解的才需要做api权限控制
 * @author: chenhao
 * @date: 2021-2-24 15:31
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiPermission {
    /**
     * 备用字段，暂时用不到
     * @return
     */
    String value() default "";
}
