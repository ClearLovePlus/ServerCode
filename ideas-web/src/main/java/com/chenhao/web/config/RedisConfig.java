package com.chenhao.web.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:自定义redis配置，先要排除spring自动的redis配置
 * @author: chenhao
 * @date: 2021-7-7 13:04
 */
@Configuration
@EnableCaching
@ConditionalOnClass(RedisPropertiesConfig.class)
public class RedisConfig extends CachingConfigurerSupport {
    private static final Logger logger= LoggerFactory.getLogger(RedisConfig.class);
    @Autowired
    private RedisPropertiesConfig redisPropertiesConfig;
    @Autowired
    private LettucePoolingClientConfiguration lettuceClientConfiguration;
    @Autowired
    private RedisSentinelConfiguration redisSentinelConfiguration;
    @Autowired
    private RedisStandaloneConfiguration redisStandaloneConfiguration;

    /**
     * redis 哨兵配置
     * @return
     */
    @Bean("redisSentinelConfiguration")
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        logger.info("哨兵模式redis配置开始初始化，节点是{}",redisPropertiesConfig.getRedisNode());
        RedisSentinelConfiguration configuration=new RedisSentinelConfiguration();
        configuration.setPassword(RedisPassword.of(redisPropertiesConfig.getPassword()));
        configuration.setMaster(redisPropertiesConfig.getMaster());
        //redis默认16个database默认往0中存储，可以设定往哪个database中存储
        configuration.setDatabase(0);
        Set<RedisNode> nodes=new HashSet<>();
        String[] nodeArray=redisPropertiesConfig.getRedisNode().split(",");
        for (String node:nodeArray){
            String[] item=node.split(":");
            nodes.add(new RedisNode(item[0].trim(),Integer.parseInt(item[1].trim())));
        }
        configuration.setSentinels(nodes);
        logger.info("哨兵模式redis配置完成初始化，节点是{}",redisPropertiesConfig.getRedisNode());
        return  configuration;
    }

    /**
     * redis 单机配置
     * @return
     */
    @Bean("redisStandaloneConfiguration")
    public RedisStandaloneConfiguration redisStandaloneConfiguration(){
        logger.info("单机模式redis配置开始初始化，节点是{}",redisPropertiesConfig.getHost()+":"+redisPropertiesConfig.getPort());
        RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration();
        configuration.setDatabase(0);
        configuration.setPassword(RedisPassword.of(redisPropertiesConfig.getPassword()));
        configuration.setPort(redisPropertiesConfig.getPort());
        configuration.setHostName(redisPropertiesConfig.getHost());
        logger.info("单机模式redis配置完成初始化，节点是{}",redisPropertiesConfig.getHost()+":"+redisPropertiesConfig.getPort());
        return configuration;
    }

    /**
     * lettuce 连接池配置
     * @return
     */
    @Bean("lettuceClientConfiguration")
    public LettucePoolingClientConfiguration lettucePoolConfig(){
        logger.info("连接池配置开始初始化");
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(redisPropertiesConfig.getMaxActive());
        poolConfig.setMinIdle(redisPropertiesConfig.getMinIdle());
        poolConfig.setMaxIdle(redisPropertiesConfig.getMaxIdle());
        poolConfig.setMinEvictableIdleTimeMillis(redisPropertiesConfig.getMinEvictableIdleTimeMills());
        poolConfig.setMaxWaitMillis(redisPropertiesConfig.getMaxWait());
        poolConfig.setTestOnCreate(redisPropertiesConfig.getTestOnCreate());
        poolConfig.setTestOnBorrow(redisPropertiesConfig.getTestOnBorrow());
        poolConfig.setTestOnReturn(redisPropertiesConfig.getTestOnReturn());
        poolConfig.setTestWhileIdle(redisPropertiesConfig.getTestWhileIdle());
        logger.info("连接池配置完成初始化");
        return LettucePoolingClientConfiguration.builder()
                .poolConfig(poolConfig)
                .commandTimeout(Duration.ofSeconds(redisPropertiesConfig.getCommandTimeout()))
                .shutdownTimeout(Duration.ofMillis(redisPropertiesConfig.getShutdownTimeout()))
                .build();
    }

    /**
     * redis 连接工厂配置
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        switch (redisPropertiesConfig.getStrategy()){
            case 1:
                logger.info("单机模式lettuce配置工厂,策略是:单机模式");
                return new LettuceConnectionFactory(redisStandaloneConfiguration,lettuceClientConfiguration);
            case 2:
                logger.info("哨兵模式lettuce配置工厂,策略是：哨兵模式");
                return new LettuceConnectionFactory(redisSentinelConfiguration,lettuceClientConfiguration);
            case 3:
                logger.info("集群模式尚未配置");
                return null;
            default:
                return null;
        }
    }

    /**
     * 配置redisTemplate
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        logger.info("开始配置redisTemplate");
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<Object>(Object.class);
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // 将默认序列化改为Jackson2JsonRedisSerializer序列化
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // key序列化
        template.setKeySerializer(jackson2JsonRedisSerializer);
        // value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // Hash key序列化
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        // Hash value序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory());
        template.afterPropertiesSet();
        logger.info("结束配置redisTemplate");
        return template;

    }
}
