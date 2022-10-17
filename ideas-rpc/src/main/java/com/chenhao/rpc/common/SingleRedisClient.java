package com.chenhao.rpc.common;

import com.chenhao.rpc.common.iface.IRedisClientInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

/**
 * @description: 纯原生方式的单机redis操作类
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
    public String setNx(String key, String value, int time) {
        RedisResultContent<String> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.setex(key,time,value));
        });
        return result.getValue();
    }

    @Override
    public String get(String key) {
        RedisResultContent<String> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.get(key));
        });
        return result.getValue();
    }

    @Override
    public long lPush(String key, String value) {
        RedisResultContent<Long> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.lpushx(key, value));
        });
        return result.getValue();
    }

    @Override
    public long lPushAll(String key, List<String> values) {
        RedisResultContent<Long> result=new RedisResultContent<>();
        String[] params=values.toArray(new String[0]);
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.lpush(key,params));
        });
        return result.getValue();
    }

    @Override
    public long hSet(String mapKey, String fieldKey, String fieldValue) {
        RedisResultContent<Long> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.hset(fieldKey,fieldKey,fieldValue));
        });
        return result.getValue();
    }

    @Override
    public String hGet(String mapKey, String fieldKey) {
        RedisResultContent<String> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.hget(mapKey,fieldKey));
        });
        return result.getValue();
    }

    @Override
    public Map<String, String> hGetAll(String mapKey) {
        RedisResultContent<Map<String,String>> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.hgetAll(mapKey));
        });
        return result.getValue();
    }

    @Override
    public long zAdd(String key, Double score, String member) {
        RedisResultContent<Long> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.zadd(key,score,member));
        });
        return result.getValue();
    }

    @Override
    public List<String> lRange(String key,long start, long end) {
        RedisResultContent<List<String>> result=new RedisResultContent<>();
        singleRedisClientManager.exec(jedis -> {
            result.setValue(jedis.lrange(key,start,end));
        });
        return result.getValue();
    }
}
