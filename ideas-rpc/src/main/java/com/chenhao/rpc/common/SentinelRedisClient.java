package com.chenhao.rpc.common;

import com.chenhao.rpc.common.iface.IRedisClientInterface;

import java.util.List;
import java.util.Map;

/**
 * @description: 纯原生哨兵模式的redis操作类
 * @author: chenhao
 * @date: 2022-3-11 11:07
 */
public class SentinelRedisClient  implements IRedisClientInterface {
    private SentinelRedisClientManager sentinelRedisClientManager;

    public SentinelRedisClient() {
        this.sentinelRedisClientManager = new SentinelRedisClientManager();
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String setNx(String key, String value, int time) {
        return null;
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

    @Override
    public List<String> lRange(String key, long start, long end) {
        return null;
    }
}
