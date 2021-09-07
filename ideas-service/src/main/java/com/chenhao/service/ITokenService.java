package com.chenhao.service;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-27 9:51
 */
public interface ITokenService {
    /**
     * 生成用于校验合法性的token
     * @param userId
     * @param userName
     * @param phoneNum
     * @return
     */
    String  createToken(Integer userId,String userName,String phoneNum) throws Exception;
}
