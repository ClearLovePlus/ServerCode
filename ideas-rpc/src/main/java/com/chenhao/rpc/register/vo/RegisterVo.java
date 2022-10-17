package com.chenhao.rpc.register.vo;

/**
 * @description: 用于注册注册中心的实体类
 * @author: chenhao
 * @date: 2022-3-9 13:29
 */
public class RegisterVo {
    /**
     * 服务名
     */
    private String key;
    /**
     * 服务的ip
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
