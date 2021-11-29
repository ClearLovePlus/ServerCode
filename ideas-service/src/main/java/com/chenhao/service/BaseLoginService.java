package com.chenhao.service;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.constants.RedisKeyConstants;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.LoginRequestDTO;
import com.chenhao.dto.response.LoginResponseDTO;
import com.chenhao.dto.response.TokenResponseDTO;
import com.chenhao.dto.validate.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:基础的登录服务
 * @author: chenhao
 * @date: 2021-5-31 15:11
 */
public abstract class BaseLoginService<R, T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginService.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IRedisClientService redisClient;

    /**
     * 前置校验
     * @param request
     * @param ignoreNames
     * @return
     * @throws Exception
     */
    protected String beforeLogin(LoginRequestDTO request,String[] ignoreNames)throws Exception{
       return ValidateUtils.validate(request,null,ignoreNames);
    }

    /**
     * 登录完成之后的一些动作
     *
     * @param t
     * @return
     * @throws Exception
     */
    protected abstract R afterLogin(T t) throws Exception;

    /**
     * 通用的登录逻辑,感觉登录实在过于简单
     *
     * @param request
     * @return
     */
    protected User login(LoginRequestDTO request) throws Exception {
        User user = userService.getUserByPhoneNum(request.getPhone());
        if (user == null) {
            throw new BusinessException(BusinessEnum.UN_EXIST_PHONE);
        }
        return user;
    }

    /**
     * 所有登录方法统一的登出接口
     * @param userId
     * @return
     * @throws Exception
     */
    protected boolean logOut(Integer userId) {
        try {
            redisClient.set(String.format(RedisKeyConstants.TOKEN_PREFIX, userId.toString()), null);
        } catch (Exception e) {
            logger.error("登出异常");
            return false;
        }
        return true;
    }

    /**
     * 判断登录状态
     * @param token
     * @return
     */
    protected Boolean loginStatus(String token){
        Object o = redisClient.get(String.format(RedisKeyConstants.TOKEN_PREFIX, token));
        if(o==null){
            return false;
        }
        TokenResponseDTO response= JSON.parseObject((String) o,TokenResponseDTO.class);
        if(StringUtils.isEmpty(response.getToken())||!token.equals(response.getToken())){
            return false;
        }
        return true;
    }

}
