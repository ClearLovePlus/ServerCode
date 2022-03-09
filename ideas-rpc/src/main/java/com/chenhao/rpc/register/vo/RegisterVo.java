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
     *
     */
    private String value;
    private String type;
    private String password;
    private boolean hasPwd;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHasPwd() {
        return hasPwd;
    }

    public void setHasPwd(boolean hasPwd) {
        this.hasPwd = hasPwd;
    }
}
