package com.chenhao.rpc.register.vo;

import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-14 15:48
 */
public class RegisterCenterVO {
    private String env;
    private String nameSpace;
    private List<RegisterCenterVO> instanceList;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public List<RegisterCenterVO> getInstanceList() {
        return instanceList;
    }

    public void setInstanceList(List<RegisterCenterVO> instanceList) {
        this.instanceList = instanceList;
    }
}
