package com.chenhao.service.impl;

import com.chenhao.common.constants.BusinessConstant;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import com.chenhao.service.BaseRegisterService;
import com.chenhao.service.ITokenService;
import com.chenhao.service.IUserNameRegisterService;
import com.chenhao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:根据用户名和密码进行注册
 * @author: chenhao
 * @date: 2021-5-19 14:02
 */
@Service("userNameRegisterService")
public class UserNameRegisterServiceImpl extends BaseRegisterService<String, User> implements IUserNameRegisterService {
    @Autowired
    private IUserService userService;
    @Autowired
    @Qualifier("localTokenService")
    private ITokenService tokenService;

    @Override
    protected Boolean checkAccount(String account, Integer type) {
        User userByUserName = userService.getUserByUserName(account);
        return userByUserName != null;
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
    public RegisterResponseDTO registerByUserName(RegisterRequestDTO request) throws Exception {
        if(StringUtils.isEmpty(request.getUserName())||StringUtils.isEmpty(request.getPassword())){
            throw new BusinessException(BusinessEnum.USER_NAME_REGISTER_EMPTY_ERROR);
        }
        if (checkAccount(request.getUserName(), 1)) {
            throw new BusinessException(BusinessEnum.ACCOUNT_IS_USED);
        }
        User newUser=new User();
        newUser.setUsername(request.getUserName());
        newUser.setPhone(request.getPhoneNum()==null? BusinessConstant.DEFAULT_PHONE :request.getPhoneNum());
        newUser.setPassword(request.getPassword());
        RegisterResponseDTO register = regitster(newUser, request.getAuthCode(), newUser.getPhone(),request.getSex());
        register.setToken(tokenService.createToken(register.getUserId(),register.getUserName(),request.getPhoneNum()));
        return register;
    }
}
