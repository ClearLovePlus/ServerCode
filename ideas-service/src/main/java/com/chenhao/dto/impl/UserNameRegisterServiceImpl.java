package com.chenhao.dto.impl;

import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import com.chenhao.dto.BaseRegisterService;
import com.chenhao.dto.IUserNameRegisterService;
import com.chenhao.dto.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-19 14:02
 */
@Service("userNameRegisterService")
public class UserNameRegisterServiceImpl extends BaseRegisterService<String, User> implements IUserNameRegisterService {
    @Autowired
    private IUserService userService;
    @Override
    protected Boolean checkAccount(String account, Integer type) {
        User userByUserName = userService.getUserByUserName(account);
        return userByUserName==null;
    }

    @Override
    protected String afterRegister(User parameter) {
        return null;
    }

    @Override
    protected String creatDefaultPassword() {
        return null;
    }

    @Override
    protected Boolean checkPassword(String password) {
        return null;
    }

    @Override
    public RegisterResponseDTO registerByUserName(RegisterRequestDTO request) throws Exception{
        return null;
    }
}
