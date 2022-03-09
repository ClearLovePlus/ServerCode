package com.chenhao.rpc.register;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: 注册中心的抽象类，需要实现何种的注册中心 请自己实现自己的注册逻辑，这个地方肢体口对基本逻辑层的抽象
 * @author: chenhao
 * @date: 2022-1-19 14:53
 */
public abstract class Register {

    /**
     * 启动注册中心，主要用于将注册中心线程启动，用于保证注册能正常启动
     * @param parameters
     */
    public  abstract  void start(Map<String,String> parameters);

    /**
     * 停止注册中心的线程，这样该服务就从注册中心被剔除了
     */
    public  abstract  void stop();

    /**
     * 往注册中心的列表中注册服务
     * @param key
     * @param value
     */
    public  abstract void  register(Set<String> key,String value);

    /**
     * 主动从注册中心剔除服务
     * @param key
     * @param value
     */
    public  abstract void  remove(Set<String> key,String value);

    /**
     * 批量进行服务发现
     * @param key
     * @return
     */
    public abstract  Map<String, TreeSet<String>> discovery(Set<String> key);

    /**
     * 进行单个的服务发现
     * @param key
     * @return
     */
    public abstract TreeSet<String> discovery(String key);
}
