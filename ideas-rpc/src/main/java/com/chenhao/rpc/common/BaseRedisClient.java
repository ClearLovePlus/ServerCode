package com.chenhao.rpc.common;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-9 14:21
 */
public abstract class BaseRedisClient <T>{

    /**
     * 初始化客户端的方法
     * @param ip 用
     * @param port
     * @param pwd
     * @return
     */
    abstract protected  T init(String ip,Integer port,String pwd);
}
