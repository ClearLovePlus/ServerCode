package com.chenhao.rpc.register.client;

import com.chenhao.rpc.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 基于Db的注册中心实体
 * @author: chenhao
 * @date: 2022-1-19 17:45
 */
public class DbRegisterClient {
    private static Logger logger = LoggerFactory.getLogger(DbRegisterClient.class);
    private String registerCenterAddress;
    private String env;
    private String nameSpace;

    private List<String> addressCluster;

    /**
     * 注册器客户端
     * @param registerCenterAddress
     * @param env
     * @param nameSpace
     */
    public DbRegisterClient(String registerCenterAddress, String env, String nameSpace) {
        this.registerCenterAddress = registerCenterAddress;
        this.env = env;
        this.nameSpace = nameSpace;

        //检测注册中心是否合法
        if(registerCenterAddress==null|| Constants.EMPTY.equals(registerCenterAddress)){
            throw  new RuntimeException("注册中心的注册地址不能为空");
        }
        //未传入环境标识，默认是测试环境
        if(env==null||Constants.EMPTY.equals(env)){
            env=Constants.DEFAULT_ENV;
        }
        //未传入命名空间标识，默认是default命名空间
        if(nameSpace==null||Constants.EMPTY.equals(nameSpace)){
            nameSpace=Constants.DEFAULT_NAME_SPACE;
        }
        addressCluster=new ArrayList<>();
        if(registerCenterAddress.contains(Constants.SPLIT_FLAG)){
            addressCluster.addAll(Arrays.asList(registerCenterAddress.split(Constants.SPLIT_FLAG)));
        }else {
            addressCluster.add(registerCenterAddress);
        }
    }



}
