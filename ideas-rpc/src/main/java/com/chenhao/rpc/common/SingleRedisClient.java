package com.chenhao.rpc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: 基于纯原生jedis的redis客户端
 * @author: chenhao
 * @date: 2022-3-9 13:44
 */
public class SingleRedisClient extends BaseRedisClient<JedisPool> {
    private static final Logger logger= LoggerFactory.getLogger(SingleRedisClient.class);
    private volatile static JedisPool jedisPool;


    @Override
    public JedisPool init(String ip, Integer port, String pwd) {
        logger.info("====the progress of creating singleRedisClient start=====");
        if (jedisPool == null) {
            synchronized (SingleRedisClient.class) {
                if (jedisPool == null) {
                    jedisPool = createJedisPool(ip, port, pwd);
                    logger.info("====the progress of creating singleRedisClient end=====");
                    return jedisPool;
                }
            }
        }
        logger.info("====the progress of creating singleRedisClient end=====");
        return jedisPool;
    }

    /**
     * 初始化jedis连接池
     * @param ip
     * @param port
     * @param pwd
     * @return
     */
    private JedisPool createJedisPool(String ip, Integer port, String pwd) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        jedisPool = new JedisPool(config, ip, port,5000,pwd);
        return jedisPool;
    }
}
