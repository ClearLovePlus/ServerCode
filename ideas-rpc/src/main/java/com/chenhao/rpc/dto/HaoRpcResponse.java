package com.chenhao.rpc.dto;

/**
 * @description: haoRpc返回实体类
 * @author: chenhao
 * @date: 2022-1-18 9:41
 */
public class HaoRpcResponse<T> {
    private String requestId;
    private int code;
    private String errorMsg;
    private T data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
