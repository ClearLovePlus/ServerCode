package com.chenhao.service;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-2 14:58
 */
@FunctionalInterface
public interface IBlogFunction<T,R> {
    /**
     * 函数的可执行类
     * @param request
     * @return
     */
    R execute(T request);
}
