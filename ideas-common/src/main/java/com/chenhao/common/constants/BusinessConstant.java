package com.chenhao.common.constants;

/**
 * @description:一些常量字符串
 * @author: chenhao
 * @date: 2021-1-21 13:23
 */
public class BusinessConstant {

    /**
     * 系统token
     */
    public final static String TOKEN_FOR_USERID = "MBUPAPI:TOKEN:FOR:UID:";


    /**
     * 系统用户
     */
    public final static String USERID_FOR_TOKEN = "MBUPAPI:UID:FOR:TOKEN:";
    /**
     * token在请求头中的key
     */

    public final static String TOKEN_IN_HEADER="Mb-Authorization";

    /**
     * 用于做api权限控制的header
     */
    public final static String API_PERMISSION_HEADER="MBUP-APP-ID";

    /**
     * get请求方式
     */
    public final static String GET_METHOD="get";
    /**
     * post请求方式
     */
    public final static String POST_METHOD="post";
    /**
     * 拥有权限的 appId集合
     */

    public final static String APPIDS_WITH_PERMISSION="appIdsWithPermission";

    /**
     * 分割符号为逗号
     */
    public final static String DELIMITER=",";
    /**
     * 默认的手机号，无意义
     */
    public final static String DEFAULT_PHONE="11000000000";
    /**
     * 对象的容量为空
     */
    public final static Integer EMPTY=0;
    /**
     * mp4格式的视频文件
     */
    public final static String MP4="mp4";
    /**
     * 文件后缀标志
     */
    public final static String POINT=".";
    /**
     * 视频文件地址
     */
    public final static String VIDEOS="videos";
    /**
     * 文档文件夹
     */
    public final static String DOCUMENT="document";
    /**
     * 不合法的用户id
     */
    public final static long ILLEGAl_USER_ID=0L;
}
