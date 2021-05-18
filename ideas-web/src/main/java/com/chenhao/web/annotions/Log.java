package com.chenhao.web.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-1-7 15:22
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 记录在本地还是往表中或者其他地方记录，还是两者都记录
     * @return
     */
    String level() default "local";

    /**
     * 记录的操作类型,一般记录修改和删除操作
     * @return
     */
    String type() default "";


}
