package com.chenhao.service;

import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;

/**
 * @description:短信注册接口
 * @author: chenhao
 * @date: 2021-5-27 14:52
 */
public interface ISmsRegisterService {
    /**
     * 短信注册接口
     * @param request
     * @return
     * @throws Exception
     */
    RegisterResponseDTO smsRegister(RegisterRequestDTO request) throws Exception;
 }
