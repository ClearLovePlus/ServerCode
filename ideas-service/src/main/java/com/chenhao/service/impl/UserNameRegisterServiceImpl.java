package com.chenhao.service.impl;

import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.utils.MD5Util;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import com.chenhao.service.BaseRegisterService;
import com.chenhao.service.IUserNameRegisterService;
import com.chenhao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        String result="eeee";
        System.out.println(result);
        //注册完成之后的一些后置操作，可以是发消息，可以是做一些数据同步等等
        return result;
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
        if(StringUtils.isEmpty(request.getPassword())||StringUtils.isEmpty(request.getUserName())){
            throw  new BusinessException(2000,"用户名和密码不能为空");
        }
        if(!checkAccount(request.getUserName(),1)){
            throw new BusinessException(2001,"该用户名已被注册，请换一个哦");
        }
        User user=new User();
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhoneNum());
        user.setUsername(request.getUserName());
        return regitster(user, request.getAuthCode(), request.getPhoneNum());
    }
}
