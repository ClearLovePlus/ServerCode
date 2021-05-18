package com.chenhao.common.enums;

/**
 * @description:系统信息枚举类，请都使用英文字符
 * @author: chenhao
 * @date: 2021-1-7 11:16
 */
public enum SystemEnum {
    SUCCESS(0,"success") ;
    private Integer code;
    private String msg;

    SystemEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
