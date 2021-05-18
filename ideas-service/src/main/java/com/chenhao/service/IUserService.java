package com.chenhao.service;


import com.chenhao.dao.entity.User;

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
}
