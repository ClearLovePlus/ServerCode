package com.chenhao.service;

import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.LoginRequestDTO;
import com.chenhao.dto.response.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:基础的登录服务
 * @author: chenhao
 * @date: 2021-5-31 15:11
 */
public abstract class BaseLoginService<R,T> {

    @Autowired
    private IUserService userService;

    /**
     * 登录完成之后的一些动作
     * @param t
     * @return
     * @throws Exception
     */
    protected abstract R afterLogin(T t) throws Exception;

    /**
     * 通用的登录逻辑,感觉登录实在过于简单
     * @param request
     * @return
     */
    protected User login(LoginRequestDTO request) throws Exception{
        User user=userService.getUserByPhoneNum(request.getPhone());
        if(user==null){
            throw new BusinessException(BusinessEnum.UN_EXIST_PHONE);
        }
        return  user;
    }


}
