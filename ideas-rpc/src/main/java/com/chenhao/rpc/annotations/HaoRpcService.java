package com.chenhao.rpc.annotations;

import java.lang.annotation.*;

/**
 * @description: HaoRpcService,打上这个注解的接口的实现类均需要被jdk反向代理
 * @author: chenhao
 * @date: 2022-1-17 17:48
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HaoRpcService {
    /**
     * 接口的版本
     */
    String version() default "";
}
