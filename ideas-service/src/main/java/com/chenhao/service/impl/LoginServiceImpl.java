package com.chenhao.service.impl;

import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.utils.MD5Util;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.LoginRequestDTO;
import com.chenhao.dto.response.LoginResponseDTO;
import com.chenhao.dto.validate.ValidateUtils;
import com.chenhao.service.BaseLoginService;
import com.chenhao.service.ILoginWithPwdService;
import com.chenhao.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:密码登录逻辑
 * @author: chenhao
 * @date: 2021-6-2 15:21
 */
@Service("loginWithPwdService")
public class LoginServiceImpl
        extends BaseLoginService<String, LoginResponseDTO> implements ILoginWithPwdService {
    @Autowired
    @Qualifier("localTokenService")
    private ITokenService tokenService;
    @Override
    protected String afterLogin(LoginResponseDTO loginResponseDTO) throws Exception {
        return null;
    }

    @Override
    public LoginResponseDTO loginWithPwd(LoginRequestDTO request) throws Exception {
        String validateString=super.beforeLogin(request,null);
        if(!validateString.equals(ValidateUtils.VALID)){
            throw new BusinessException(2021,validateString);
        }
        if(StringUtils.isEmpty(request.getPhone())||StringUtils.isEmpty(request.getPassword())){
           throw  new BusinessException(BusinessEnum.PHONE_OR_PWD_IS_NULL);
        }
        User user = login(request);
        if(!request.getPhone().equals(user.getPhone())){
            throw new BusinessException(BusinessEnum.PHONE_OR_PWD_ERROR);
        }
        String pwd= MD5Util.encode(request.getPassword());
        if(!pwd.equals(user.getPassword())){
            throw new BusinessException(BusinessEnum.PHONE_OR_PWD_ERROR);
        }
        LoginResponseDTO response=new LoginResponseDTO();
        response.setUserName(user.getUsername());
        response.setToken(tokenService.createToken(user.getId(),user.getUsername(),user.getPhone()));
        response.setUserId(user.getId());
        response.setAvatar(user.getAvatarimgurl());
        return response;
    }

    @Override
    public Boolean logout(Integer userId) {
        return super.logOut(userId);
    }

    @Override
    public Boolean loginStatus(String token) {
        return super.loginStatus(token);
    }
}
