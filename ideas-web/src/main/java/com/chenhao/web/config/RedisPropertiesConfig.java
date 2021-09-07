package com.chenhao.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-7 13:27
 */
@Configuration
@Component
public class RedisPropertiesConfig {
    /**
     * sentinel 配置
     */
    @Value("${spring.redis.sentinel.nodes}")
    private String redisNode;
    @Value("${spring.redis.sentinel.master}")
    private String master;
    @Value("${spring.redis.password:tebon2017}")
    private String password;

    /**
     *连接池的配置
     */
    @Value("${redis.pool.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.pool.minIdle}")
    private Integer minIdle;
    @Value("${redis.pool.maxActive}")
    private Integer maxActive;
    @Value("${redis.pool.maxWait}")
    private Integer maxWait;
    @Value("${redis.pool.minEvictableIdleTimeMills}")
    private Integer minEvictableIdleTimeMills;
    @Value("${redis.pool.testOnCreate}")
    private Boolean testOnCreate;
    @Value("${redis.pool.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.pool.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${redis.pool.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${redis.pool.commandTimeout}")
    private Integer commandTimeout;
    @Value("${redis.pool.shutdownTimeout}")
    private Integer shutdownTimeout;

    /**
     * redis使用模式配置
     */
    @Value("${redis.model.strategy}")
    private Integer strategy;
    /**
     * 单机redis配置
     */
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.host}")
    private String  host;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRedisNode() {
        return redisNode;
    }

    public void setRedisNode(String redisNode) {
        this.redisNode = redisNode;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getMinEvictableIdleTimeMills() {
        return minEvictableIdleTimeMills;
    }

    public void setMinEvictableIdleTimeMills(Integer minEvictableIdleTimeMills) {
        this.minEvictableIdleTimeMills = minEvictableIdleTimeMills;
    }

    public Boolean getTestOnCreate() {
        return testOnCreate;
    }

    public void setTestOnCreate(Boolean testOnCreate) {
        this.testOnCreate = testOnCreate;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Integer getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(Integer commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public Integer getShutdownTimeout() {
        return shutdownTimeout;
    }

    public void setShutdownTimeout(Integer shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }
}
