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
     * 参数定义的最小值错误
     */
    MISSING_MIN_VALUE(506,"参数最小值需要大于%s"),
    /**
     * 记录不存在
     */
    NO_RECORD(504,"this record is not exist"),
    /**
     * 访问接口未带权限标识 appId
     */
    NO_API_PERMISSION(505,"no permission to this api without appId"),
    /**
     * 用户名密码注册 用户自定义的用户名密码为空
     */
    USER_NAME_REGISTER_EMPTY_ERROR(2000,"自定义用户名或者密码为空"),
    /**
     * 账号不可用，已经被注册
     */
    ACCOUNT_IS_USED(2001, "该账号已被注册"),
    /**
     * 用户id和用户名不能为空
     */
    MISSING_USER_ID_OR_USER_NAME(2002,"用户id和用户名不能为空"),
    /**
     * 短信验证码错误
     */
    AUTH_CODE_ERROR(2003,"短信验证码错误"),
    /**
     * 手机号已经被注册
     */
    REPEAT_PHONE_NUM(2004,"该手机号已经被注册"),
    /**
     * 手机号不存在
     */
    UN_EXIST_PHONE(2005,"该手机号不存在或者已被注销"),
    /**
     * 手机号不存在
     */
    PHONE_OR_PWD_IS_NULL(2006,"手机号或者密码为空"),
    /**
     * 用户名密码错误
     */
    PHONE_OR_PWD_ERROR(2007,"用户名密码错误"),
    /**
     * 上传的文件不能为空
     */
    FILE_IS_EMPTY(2008,"文件不能为空"),
    /**
     * 不支持的文件类型
     */
    FILE_UN_SUPPORT(2009,"不支持的文件类型"),
    /**
     * 文件大小限制
     */
    FILE_SIZE_NOT_ALLOWED(2010,"文件大小不能超过%sM"),
    /**
     * 文件名不能为空
     */
    FILE_NAME_IS_NULL(2011,"文件名不能为空"),
    /**
     * 下载的文件无对应生成的文件
     */
    FILE_TARGET_NAME_IS_NULL(2012,"该文件无对应上传的文件"),
    /**
     * 该appId 无权限访问此接口
     */
    APP_ID_WITH_NO_PERMISSION(506,"the appId has no permission to this api"),
    /**
     * 用户未登录
     */
    USER_NOT_LOGIN_IN(2013,"用户未登录或登录态已经失效，请重新登录"),
    /**
     * 没有新增和修改文章的权限
     */
    NO_PERMISSION_TO_WRITE(2014,"无新增或者修改文章的权限"),
    /**
     * 文章不存在或者已经被删除
     */
    NO_ARTICLE_EXIST(2015,"该文章不存在或者已经被删除");
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
