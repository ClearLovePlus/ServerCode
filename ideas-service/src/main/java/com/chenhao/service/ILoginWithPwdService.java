package com.chenhao.service;

import com.chenhao.dto.request.LoginRequestDTO;
import com.chenhao.dto.response.LoginResponseDTO;

/**
 * @description:用户名密码登录
 * @author: chenhao
 * @date: 2021-6-2 15:13
 */
public interface ILoginWithPwdService {

    /**
     * 用户名和密码登录
     * @param request
     * @return
     * @throws Exception
     */
    LoginResponseDTO loginWithPwd(LoginRequestDTO request) throws Exception;

    /**
     * 登出服务
     * @param userId
     * @return
     */
    Boolean logout(Integer userId);
}
