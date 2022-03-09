package com.chenhao.rpc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 哨兵模式的redis客户端实例化方法
 * @author: chenhao
 * @date: 2022-3-9 14:33
 */
public class SentinelRedisClient extends BaseRedisClient<JedisSentinelPool> {
    private static final Logger logger = LoggerFactory.getLogger(SentinelRedisClient.class);
    private volatile static JedisSentinelPool jedisSentinelPool;

    /**
     * //可用连接实例的最大数目，默认为8；
     * //如果赋值为-1，则表示不限制，如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
     */
    private static final Integer MAX_TOTAL = 1024;
    /**
     * //控制一个pool最多有多少个状态为idle(空闲)的jedis实例，默认值是8
     */
    private static final Integer MAX_IDLE = 200;
    /**
     * //等待可用连接的最大时间，单位是毫秒，默认值为-1，表示永不超时。
     * //如果超过等待时间，则直接抛出JedisConnectionException
     */
    private static final Integer MAX_WAIT_MILLIS = 10000;
    /**
     * //客户端超时时间配置
     */
    private static final Integer TIMEOUT = 10000;
    /**
     * //在borrow(用)一个jedis实例时，是否提前进行validate(验证)操作；
     * /如果为true，则得到的jedis实例均是可用的
     */
    private static final Boolean TEST_ON_BORROW = true;
    /**
     * 在空闲时检查有效性, 默认false
     */
    private static final Boolean TEST_WHILE_IDLE = true;
    //是否进行有效性检查
    private static final Boolean TEST_ON_RETURN = true;

    @Override
    protected JedisSentinelPool init(String ip, Integer port, String pwd) {
        if (jedisSentinelPool == null) {
            synchronized (SentinelRedisClient.class) {
                if (jedisSentinelPool == null) {
                    logger.info("the progress of creating sentinelRedisClient start");
                    jedisSentinelPool = create(ip, port, pwd);
                    logger.info("the progress of creating sentinelRedisClient end");
                    return jedisSentinelPool;
                }
            }
        }
        return jedisSentinelPool;
    }


    /**
     * 用于创建
     *
     * @param ip
     * @param port
     * @param pwd
     * @return
     */
    private JedisSentinelPool create(String ip, Integer port, String pwd) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_TOTAL);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT_MILLIS);
        config.setTestOnBorrow(TEST_ON_BORROW);
        config.setTestWhileIdle(TEST_WHILE_IDLE);
        config.setTestOnReturn(TEST_ON_RETURN);
        String masterName = "jgmaster";
        String[] split = ip.split(";");
        Set<String> nodes = new HashSet<>();
        for (String s : split) {
            nodes.add(new HostAndPort(s, port).toString());
        }
        jedisSentinelPool = new JedisSentinelPool(masterName, nodes, config, 5000, pwd);
        return jedisSentinelPool;
    }

    public static void main(String[] args) {
        SentinelRedisClient client=new SentinelRedisClient();
        JedisSentinelPool init = client.init("127.0.0.1", 6379, "123456");
        Jedis resource = init.getResource();
    }
}
