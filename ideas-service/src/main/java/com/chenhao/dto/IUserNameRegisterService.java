package com.chenhao.dto;


import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-19 13:28
 */
public interface IUserNameRegisterService {
    /**
     * 通过用户名注册
     * @param request
     * @return
     * @throws Exception
     */
    RegisterResponseDTO registerByUserName(RegisterRequestDTO request) throws Exception;
}
