package com.chenhao.service.impl;

import com.chenhao.service.IRedisClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @description:redisCilent 支持单机、集群或者哨兵
 * @author: chenhao
 * @date: 2021-7-7 15:22
 */
@Component("redisClient")
public class RedisClient implements IRedisClientService {
    private static final Logger logger = LoggerFactory.getLogger(RedisClient.class);

    private final RedisTemplate<String, Object> redisTemplate;
    /**
     * redis 分布式锁lua脚本
     */
    private static final String REDIS_LOCK;

    public RedisClient(@Autowired RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //静态代码块用来初始化lua脚本
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        REDIS_LOCK = sb.toString();
    }

    @Override
    public boolean set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    @Override
    public boolean setNx(String key, Object value, Long expireTimeMills) {
        return false;
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return this.redisTemplate;
    }

    @Override
    public Boolean tryLock(String key, String requestId, long expireTime, TimeUnit timeUnit) {
        try {
            logger.info("开始设置分布式锁{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId);
            RedisCallback<Boolean> callback = connection -> {
                return connection.set(key.getBytes(StandardCharsets.UTF_8),
                        requestId.getBytes(StandardCharsets.UTF_8),
                        Expiration.seconds(timeUnit.toSeconds(expireTime)),
                        RedisStringCommands.SetOption.SET_IF_ABSENT);
            };
            logger.info("结束设置分布式锁{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId);
            return (Boolean) redisTemplate.execute(callback);
        } catch (Exception e) {
            logger.error("设置分布式锁发生异常{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId,e);
            return false;
        }

    }

    @Override
    public Boolean releaseLock(String key, String requestId) {
        try {
            logger.info("开始释放分布式锁{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId);
            RedisCallback<Boolean> callback=connection -> {
             return connection.eval(REDIS_LOCK.getBytes(StandardCharsets.UTF_8), ReturnType.BOOLEAN,1,key.getBytes(StandardCharsets.UTF_8),requestId.getBytes(StandardCharsets.UTF_8));
            };
            logger.info("结束释放分布式锁{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId);
            return (Boolean) redisTemplate.execute(callback);

        }catch (Exception e){
            logger.error("释放分布式锁发生异常{\n"+"key={}"+"\n"+"value={}"+"}",key,requestId,e);
            return false;
        }
    }

    @Override
    public String getContentOfLock(String key) {
       return (String)this.get(key);
    }
}
