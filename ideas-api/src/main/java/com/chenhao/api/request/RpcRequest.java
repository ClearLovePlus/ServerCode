package com.chenhao.api.request;

import java.io.Serializable;

/**
 * rpc请求类
 */
public class RpcRequest implements Serializable {
    private static final long serialVersionUID=1L;

    private  String methodName;
    private  Object object;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "methodName='" + methodName + '\'' +
                ", object=" + object +
                '}';
    }
}
