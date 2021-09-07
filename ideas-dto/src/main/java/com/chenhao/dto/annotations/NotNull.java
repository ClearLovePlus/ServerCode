package com.chenhao.dto.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:是否可以为空
 * @author: chenhao
 * @date: 2021-6-9 14:21
 */
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    /**
     * 需要判断是否为空的字段名
     * @return
     */
    int minValue() default 0;
}
