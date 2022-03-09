package com.chenhao.rpc.common.iface;

import java.time.Duration;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-9 17:09
 */
public interface IRedisClientInterface<T> {

    /**
     * redis command--set
     * @param key
     * @param value
     * @return
     */
    boolean set(String key,String value);

    /**
     * redis command--setNx
     * @param key
     * @param value
     * @param time
     * @param unit
     * @return
     */
    boolean setNx(String key, String value, Long time, TimeUnit unit);

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


}
