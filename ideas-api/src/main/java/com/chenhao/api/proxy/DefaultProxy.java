package com.chenhao.api.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 默认代理类
 * @author: chenhao
 * @date: 2022-1-13 16:45
 */
public class DefaultProxy implements InvocationHandler {
    private Object target;
    public Object bind(Object o){
        this.target=o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        result=method.invoke(target,args);
        return result;
    }
}
