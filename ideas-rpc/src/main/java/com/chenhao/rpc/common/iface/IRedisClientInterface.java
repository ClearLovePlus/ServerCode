package com.chenhao.rpc.common.iface;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @description:操作redis的接口层，不同模式的redis具体实现类 可以实现这个方法
 * @author: chenhao
 * @date: 2022-3-9 17:09
 */
public interface IRedisClientInterface {

    /**
     * redis command--set
     * @param key
     * @param value
     * @return
     */
    String set(String key,String value);

    /**
     * redis command--setNx
     * @param key
     * @param value
     * @param time
     * @return
     */
    String setNx(String key, String value, int time);

    /**
     * redis command--get
     * @param key
     * @return
     */
    String get(String key);

    /**
     * redis command--lpush
     * @param key
     * @param value
     * @return
     */
    long lPush(String key,String value);

    /**
     * redisl command--lpush
     * @param key
     * @param values
     * @return
     */
    long lPushAll(String key, List<String> values);

    /**
     * redis command--hset
     * @param mapKey
     * @param fieldKey
     * @param fieldValue
     * @return
     */
    long hSet(String mapKey,String fieldKey,String fieldValue);

    /**
     * redis command--hget
     * @param mapKey
     * @param fieldKey
     * @return
     */
    String hGet(String mapKey,String fieldKey);

    /**
     * redis command--hgetall
     * @param mapKey
     * @return
     */
    Map<String,String> hGetAll(String mapKey);

    /**
     * redis command--zAdd
     * @param key
     * @param score
     * @param member
     * @return
     */
    long zAdd(String key,Double score,String member);

    /**
     * redis command--lRange
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> lRange(String key,long start,long end);

}
