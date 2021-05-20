package com.chenhao.service;

import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:基础服务类
 * @author: chenhao
 * @date: 2021-5-17 14:22
 */
@Component("registerBaseService")
public abstract class BaseRegisterService<R, T> {
    @Autowired
    private IUserService userService;

    /**
     * 可以有各种注册方式：短信，用户名+密码，一键登录，联合的登录等等
     * @param account
     * @param type
     * @return
     */
    protected abstract Boolean checkAccount(String account, Integer type);

    /**
     * 抽象出来的用于注册完成后的后置操作
     * @param parameter
     * @return
     */
    protected abstract R afterRegister(T parameter);

    /**
     * 不是自定义用户名密码的时候自动生成默认的密码
     * @return
     */
    protected abstract String creatDefaultPassword();

    /**
     * 校验自定义的用户名密码是否合理
     * @param password
     * @return
     */
    protected abstract Boolean checkPassword(String password);

    /**
     * 通用的注册主流程
     * @param user
     * @return
     */
    protected RegisterResponseDTO regitster(User user, String authCode, String phoneNum) {
        //学习下build模式下 要用的东西，其实业务设计的过程中完全没有必要
        RegisterRequestDTO request = new RegisterRequestDTO.RegisterRequestDTOBuilder(user.getUsername(), user.getPassword())
                .authCode(authCode)
                .phoneNum(phoneNum)
                .build();
        Integer integer = userService.addUser(request);
        RegisterResponseDTO response=new RegisterResponseDTO();
             response.setUserId(integer);
             response.setUserName(user.getUsername());
             response.setToken("todoToken");
             return response;
    }
}
