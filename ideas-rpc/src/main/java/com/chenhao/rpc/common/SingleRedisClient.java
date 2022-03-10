package com.chenhao.rpc.common;

import com.chenhao.rpc.common.iface.ICallerInterface;
import com.chenhao.rpc.common.iface.IRedisClientInterface;
import com.chenhao.rpc.common.iface.IRedisExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-10 10:57
 */
public class SingleRedisClient implements IRedisClientInterface {
    private static final Logger logger= LoggerFactory.getLogger(SingleRedisClient.class);

    private SingleRedisClientManager singleRedisClientManager;
    /**
     * 初始化单例模式客户端
     */
    public SingleRedisClient() {
        this.singleRedisClientManager = new SingleRedisClientManager();
    }
    @Override
    public String set(String key, String value) {
        RedisResultContent<String> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.set(key,value));
        });
        return result.getValue();
    }

    @Override
    public boolean setNx(String key, String value, Long time, TimeUnit unit) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public long lPush(String key, String value) {
        return 0;
    }

    @Override
    public long lPushAll(String key, List<String> values) {
        return 0;
    }

    @Override
    public long hSet(String mapKey, String fieldKey, String fieldValue) {
        return 0;
    }

    @Override
    public String hGet(String mapKey, String fieldKey) {
        return null;
    }

    @Override
    public Map<String, String> hGetAll(String mapKey) {
        return null;
    }

    @Override
    public long zAdd(String key, Double score, String member) {
        return 0;
    }
}
