package com.chenhao.rpc.register.client;

import com.chenhao.rpc.register.vo.RegisterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 基于redis的注册中心客户端
 * @author: chenhao
 * @date: 2022-3-15 15:59
 */
public class RedisRegisterClient {
    private static Logger logger = LoggerFactory.getLogger(RedisRegisterClient.class);
    private volatile Set<RegisterVo> registerInstances=new HashSet<>();
    private volatile ConcurrentHashMap<String,  TreeSet<String>> discoveryInstances=new ConcurrentHashMap<>();
    /**
     * 服务发现线程
     */
    private Thread discoveryThread;
    /**
     * 服务注册线程
     */
    private Thread registerThread;
    /**
     * 基础服务客户端
     */
    private RegisterClient registerClient;
    //用来判断注册线程是否被终止，用于调用destroy方法
    private volatile boolean registerThreadStop=false;
    public RedisRegisterClient(String adminAddress,String nameSpace,String env,String redisType){
        registerClient=new RegisterClient(adminAddress,env,nameSpace,redisType);
        logger.info("start init RedisRegisterClient.......[adress={},nameSpace={},env={},redisType={}]",adminAddress,nameSpace,env,redisType);
        //注册线程
        registerThread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        registerThread.setDaemon(true);
        registerThread.setName("ha-rpc registerThread");
        registerThread.start();
        //发现线程，主要用于更新本地注册表
        discoveryThread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    /**
     * 调用registerClient 用于注册服务
     * @param registerList
     */
    public void register(List<RegisterVo> registerList){
        if(registerList==null||registerList.isEmpty()){
            throw new RuntimeException("registerLSit can not be empty");
        }
        registerInstances.addAll(registerList);
        registerClient.registry(registerList);
    }

    /**
     * 剔除注册上来的客户端
     * @param registerList
     */
    public void remove(List<RegisterVo> registerList){
        if (registerList==null||registerList.isEmpty()){
            throw new RuntimeException("registerList can not be empty");
        }
        registerInstances.removeAll(registerList);
        registerClient.remove(registerList);
    }


    /**
     * 服务发现
     * @param keys
     * @return
     */
    public Map<String,TreeSet<String>> discovery(List<String> keys){
        if(keys==null||keys.isEmpty()){
            throw new RuntimeException("keys can not be empty");
        }
        Map<String,TreeSet<String>> result=new HashMap<>();
        keys.forEach(p->{
           TreeSet<String>cacheMap = discoveryInstances.get(p);
            if(cacheMap!=null){
                result.put(p,cacheMap);
            }
        });
        if(keys.size()==result.size()){
            return result;
        }
        //说明本地缓存的注册表中没找到对应的服务，需要从远程获取

    }

}
