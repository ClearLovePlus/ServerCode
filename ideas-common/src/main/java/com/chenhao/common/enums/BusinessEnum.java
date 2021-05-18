package com.chenhao.common.enums;


/**
 * @description:业务枚举类,为了系统兼容请都使用英文
 * @author: chenhao
 * @date: 2021-1-7 11:10
 */
public enum BusinessEnum {
    /**
     * 默认成功
     */
    SUCCESS(200,"success"),
    /**
     * 无访问权限
     */
    NO_PERMISSION(501,"no permission"),
    /**
     * 缺少必要的参数
     */
    MISSING_HEADER(502,"missing required Header token"),
    /**
     * 缺少参数
     */
    MISSING_PARAMETER(503,"missing required parameter %s"),
    /**
     * 记录不存在
     */
    NO_RECORD(504,"this record is not exist"),
    /**
     * 访问接口未带权限标识 appId
     */
    NO_API_PERMISSION(505,"no permission to this api without appId"),
    /**
     * 该appId 无权限访问此接口
     */
    APP_ID_WITH_NO_PERMISSION(506,"the appId has no permission to this api");
    ;
    private Integer code;
    private String  msg;
    BusinessEnum(Integer code,String msg){
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
