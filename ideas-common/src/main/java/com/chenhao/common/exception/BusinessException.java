package com.chenhao.common.exception;

import com.chenhao.common.enums.BusinessEnum;

/**
 * @description:业务异常类
 * @author: chenhao
 * @date: 2021-1-7 10:55
 */
public class BusinessException extends Exception{
    /**
     * 异常码，请在BusinessEnum中定义
     */
    private Integer errorCode;
    /**
     * 异常信息
     */
    private String msg;

    public BusinessException(){
        super("unknown error");
        this.errorCode=-1;
    }
    public BusinessException(Integer errorCode,String errorMsg){
        this.msg=errorMsg;
        this.errorCode=errorCode;
    }
    public BusinessException(BusinessEnum en){
        this.msg=en.getMsg();
        this.errorCode=en.getCode();
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
