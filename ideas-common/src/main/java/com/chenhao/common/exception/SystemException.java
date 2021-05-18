package com.chenhao.common.exception;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-1-7 11:20
 */
public class SystemException extends Exception{
    private Integer errorCode;
    private String  msg;
    public SystemException(){
        super("system error");
        this.errorCode=500;
    }
    public SystemException(Integer errorCode,String msg){
        super(msg);
        this.errorCode=errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
