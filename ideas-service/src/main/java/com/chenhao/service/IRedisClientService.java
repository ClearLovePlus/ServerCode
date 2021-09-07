package com.chenhao.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: redis操作类，提供redis对外暴露的接口
 * @author: chenhao
 * @date: 2021-7-7 15:07
 */
public interface IRedisClientService{
    /**
     * 持久化存储没有失效日期
     * @param key
     * @param value
     * @return
     */
    boolean set(String key,Object value);

    /**
     * 带失效时间的操作
     * @param key
     * @param value
     * @param expireTimeMills
     * @return
     */
    boolean setNx(String key,Object value,Long expireTimeMills);

    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 对外提供一个对外的RedisTemplate
     * @return
     */
    RedisTemplate<String,Object> getRedisTemplate();

    /**
     * 获取redis分布式锁接口
     * @param key  分布式锁的key
     * @param requestId 每次请求带的东西，什么东西都行
     * @param expireTime 多久后锁会失效 防止死锁
     * @param timeUnit 时间单位
     * @return
     */
    Boolean tryLock(String key, String requestId, long expireTime, TimeUnit timeUnit);

    /**
     * 释放分布式锁
     * @param key 分布式锁的key
     * @param requestId 该锁的内容 请求带入的
     * @return
     */
    Boolean releaseLock(String key,String requestId);

    /**
     * 获取分布式锁的内容
     * @param key 分布式锁的key
     * @return 锁的内容
     */
    String  getContentOfLock(String key);
}
