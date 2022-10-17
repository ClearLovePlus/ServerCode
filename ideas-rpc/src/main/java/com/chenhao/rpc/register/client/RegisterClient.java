package com.chenhao.rpc.register.client;

import com.chenhao.rpc.common.Constants;
import com.chenhao.rpc.common.SentinelRedisClient;
import com.chenhao.rpc.common.SingleRedisClient;
import com.chenhao.rpc.common.iface.IRedisClientInterface;
import com.chenhao.rpc.register.vo.RegisterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @description: 基于Db的注册中心实体
 * @author: chenhao
 * @date: 2022-1-19 17:45
 */
public class RegisterClient {
    private static Logger logger = LoggerFactory.getLogger(RegisterClient.class);
    private String registerCenterAddress;
    private String env;
    private String nameSpace;

    private List<String> addressCluster;
    private IRedisClientInterface redisClientInterface;
    private String redisType;
    private static final String SINGLE = "single";
    private static final String REDIS_KEY = "%s:%s:%s";

    /**
     * 注册器客户端
     *
     * @param registerCenterAddress
     * @param env
     * @param nameSpace
     */
    public RegisterClient(String registerCenterAddress, String env, String nameSpace, String redisType) {
        this.registerCenterAddress = registerCenterAddress;
        this.env = env;
        this.nameSpace = nameSpace;
        this.redisType = redisType;

        //检测注册中心是否合法
        if (registerCenterAddress == null || Constants.EMPTY.equals(registerCenterAddress)) {
            throw new RuntimeException("注册中心的注册地址不能为空");
        }
        //未传入环境标识，默认是测试环境
        if (env == null || Constants.EMPTY.equals(env)) {
            env = Constants.DEFAULT_ENV;
        }
        //未传入命名空间标识，默认是default命名空间
        if (nameSpace == null || Constants.EMPTY.equals(nameSpace)) {
            nameSpace = Constants.DEFAULT_NAME_SPACE;
        }
        addressCluster = new ArrayList<>();
        if (registerCenterAddress.contains(Constants.SPLIT_FLAG)) {
            addressCluster.addAll(Arrays.asList(registerCenterAddress.split(Constants.SPLIT_FLAG)));
        } else {
            addressCluster.add(registerCenterAddress);
        }
        if (!SINGLE.equals(redisType)) {
            this.redisClientInterface = new SentinelRedisClient();
        } else {
            this.redisClientInterface = new SingleRedisClient();
        }
    }

    /**
     * 基础注册服务
     *
     * @param providerInstances
     */
    public void registry(List<RegisterVo> providerInstances) {
        if (providerInstances == null || providerInstances.isEmpty()) {
            throw new RuntimeException("ha-rpc provider can not be empty");
        }
        String key = String.format(REDIS_KEY, this.env, this.nameSpace, providerInstances.get(0).getKey());
        List<String> instanceIp = new ArrayList<>(providerInstances.size());
        providerInstances.forEach(p -> {
            instanceIp.add(p.getValue());
        });
        this.redisClientInterface.lPushAll(REDIS_KEY, instanceIp);
    }

    /**
     * 从当前注册中心列表中移除服务
     *
     * @param removeInstances
     */
    public void remove(List<RegisterVo> removeInstances) {
        if (removeInstances == null || removeInstances.isEmpty()) {
            throw new RuntimeException("ha-rpc removeInstances can not be empty");
        }
        String key = String.format(REDIS_KEY, this.env, this.nameSpace, removeInstances.get(0).getKey());
        List<String> oldInstances = this.redisClientInterface.lRange(key, 0L, -1L);
        List<String> needToBeRemoved = new ArrayList<>(removeInstances.size());
        removeInstances.forEach(p -> {
            needToBeRemoved.add(p.getValue());
        });
        oldInstances.removeAll(needToBeRemoved);
        this.redisClientInterface.lPushAll(key, oldInstances);
    }

    /**
     * 服务发现，通过服务名发现远程的ip
     *
     * @param keys
     * @return
     */
    public Map<String, TreeSet<String>> discovery(Set<String> keys) {
        if (keys == null || keys.size() == 0) {
            throw new RuntimeException("ha-rpc keys can not be empty");
        }
        Map<String, TreeSet<String>> discoveryData = new HashMap<>();
        keys.forEach(p->{
            String key=String.format(REDIS_KEY,this.env,this.nameSpace,p);
            List<String> liveInstances = redisClientInterface.lRange(key, 0L, -1L);
            discoveryData.put(p,new TreeSet<>(liveInstances));
        });
       return discoveryData;
    }

}
