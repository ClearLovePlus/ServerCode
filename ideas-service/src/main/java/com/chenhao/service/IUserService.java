package com.chenhao.service;


import com.chenhao.dao.entity.User;
import com.chenhao.dto.request.ChangePwdRequestDTO;
import com.chenhao.dto.request.RegisterRequestDTO;

import java.util.Date;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-18 15:07
 */
public interface IUserService {
    /**
     * 根据userName获取用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     *根据id获取用户信息
     * @param id
     * @return
     */
    User getUserByUserId(Integer id);

    /**
     * 新增用户角色
     * @param request
     * @return
     */
    Integer addUser(RegisterRequestDTO request);

    /**
     * 通过手机号查询用户信息
     * @param phoneNum
     * @return
     */
    User getUserByPhoneNum(String phoneNum);

    /**
     * 修改密码
     * @param request
     * @return
     * @throws Exception
     */
    Boolean changeUserPwd(ChangePwdRequestDTO request) throws Exception;

    /**
     * 判断是否是节假日
     * @param isBroker
     * @param date
     * @return
     * @throws Exception
     */
    Boolean isHoliday(Boolean isBroker, String date) throws Exception;
}
