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

}
