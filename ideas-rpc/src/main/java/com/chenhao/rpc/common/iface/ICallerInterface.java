package com.chenhao.rpc.common.iface;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-10 13:38
 */
public interface ICallerInterface {
    /**
     * 统一的调用接口
     * @param jedis
     */
  void call(Jedis jedis);
}
