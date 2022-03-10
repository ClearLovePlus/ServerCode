package com.chenhao.rpc.common;

import com.chenhao.rpc.common.iface.ICallerInterface;
import com.chenhao.rpc.common.iface.IRedisExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @description: 基于纯原生jedis的redis客户端
 * @author: chenhao
 * @date: 2022-3-9 13:44
 */
public class SingleRedisClientManager extends BaseRedisClient<JedisPool> implements IRedisExecutor {
    private static final Logger logger= LoggerFactory.getLogger(SingleRedisClientManager.class);
    public volatile static JedisPool jedisPool;

    public SingleRedisClientManager() {
        jedisPool=init("123.56.164.61", 6379, "123456");
    }

    @Override
    public JedisPool init(String ip, Integer port, String pwd) {
        logger.info("====the progress of creating singleRedisClient start=====");
        if (jedisPool == null) {
            synchronized (SingleRedisClientManager.class) {
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

    @Override
    public void exec(ICallerInterface caller) {
        //从链接池子中获取
        Jedis jedis = jedisPool.getResource();
        try {
            //调用redis
            logger.info("start call redis");
            caller.call(jedis);

        } catch (JedisConnectionException jedisConnectionException) {
            //失败重试一次
            logger.error("call redis error reCall one time",jedisConnectionException);
            caller.call(jedis);
        } finally {
            logger.info("close redis connection");
            jedis.close();
        }
    }
}
