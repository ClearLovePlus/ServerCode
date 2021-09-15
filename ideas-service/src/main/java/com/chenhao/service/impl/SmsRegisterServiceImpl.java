package com.chenhao.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.constants.RedisKeyConstants;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.utils.MD5Util;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import com.chenhao.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:短信注册实现类
 * @author: chenhao
 * @date: 2021-5-27 15:05
 */
@Service(value = "smsRegisterService")
public class SmsRegisterServiceImpl extends BaseRegisterService<String, RegisterRequestDTO> implements ISmsRegisterService {
    private static final Logger logger= LoggerFactory.getLogger(SmsRegisterServiceImpl.class);

    @Autowired
    IRedisClientService redisClient;
    @Autowired
    private IUserService userService;
    @Autowired
    @Qualifier("localTokenService")
    private ITokenService tokenService;

    @Override
    public RegisterResponseDTO smsRegister(RegisterRequestDTO request) throws Exception {
        String authCode =(String) redisClient.getRedisTemplate().opsForValue().get(String.format(RedisKeyConstants.REGISTER_PREFIX, request.getPhoneNum()));
        if (StringUtils.isEmpty(authCode)) {
            throw new BusinessException(BusinessEnum.AUTH_CODE_ERROR);
        }
        if (!authCode.equals(request.getAuthCode())) {
            throw new BusinessException(BusinessEnum.AUTH_CODE_ERROR);
        }
        if (!checkAccount(request.getPhoneNum(),1)) {
            throw new BusinessException(BusinessEnum.REPEAT_PHONE_NUM);
        }
        User newUser=new User();
        newUser.setPassword(MD5Util.encode(creatDefaultPassword()));
        newUser.setUsername(request.getPhoneNum());
        newUser.setPhone(request.getPhoneNum());
        RegisterResponseDTO register = regitster(newUser, request.getAuthCode(), request.getPhoneNum(),request.getSex());
        register.setToken(tokenService.createToken(register.getUserId(),register.getUserName(),request.getPhoneNum()));
        //注册完成的一些后置操作,其实可以是异步的
        afterRegister(request);
        logger.info("注册完成,返回值:{}",JSON.toJSONString(register));
        return register;
    }

    @Override
    protected Boolean checkAccount(String account, Integer type) {
        return userService.getUserByPhoneNum(account)==null;
    }

    @Override
    protected String afterRegister(RegisterRequestDTO parameter) {
        //todo 这里可以是 注册完成之后一些后置操作，可以是发消息，可以是数据同步啥的
        System.out.println("短信注册完成");
        String result="短信注册完成";
        logger.info("短信注册完成：{}", JSON.toJSONString(parameter));
        return result;
    }

    @Override
    protected String creatDefaultPassword() {
        //可以写个自动生成密码的逻辑，但是这样，然后将初始密码通过手机短信或者邮箱等发送给用户
        String defaultPassword = "123456";
        return defaultPassword;
    }

    @Override
    protected Boolean checkPassword(String password) {
        return null;
    }
}
