package com.chenhao.service.impl;

import com.chenhao.common.utils.HolidayUtil;
import com.chenhao.common.utils.MD5Util;
import com.chenhao.dao.entity.User;
import com.chenhao.dao.entity.UserExample;
import com.chenhao.dao.mapper.UserMapper;
import com.chenhao.dto.request.ChangePwdRequestDTO;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.service.IUserService;
import com.chenhao.service.config.HolidayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-19 10:02
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HolidayConfig config;
    @Override
    public User getUserByUserName(String userName) {
        UserExample example=new UserExample();
        //根据用户名和有效状态查询用户信息
        example.createCriteria().andUsernameEqualTo(userName).andIsActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByUserId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addUser(RegisterRequestDTO request) {
        User user=new User();
        user.setUsername(request.getUserName());
        user.setPhone(request.getPhoneNum());
        user.setPassword(MD5Util.encode(request.getPassword()));
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public User getUserByPhoneNum(String phoneNum) {
        UserExample example=new UserExample();
        example.createCriteria().andPhoneEqualTo(phoneNum).andIsActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    @Override
    public Boolean changeUserPwd(ChangePwdRequestDTO request) throws Exception {
        return null;
    }

    @Override
    public Boolean isHoliday(Boolean isBroker, String date) throws Exception {
        List<String> holidaysWithOutWeekends= Arrays.asList(config.getHolidaysWithOutWeekends().split(","));
        List<String> extraWorkDays=Arrays.asList(config.getExtraWorkDays().split(","));
        return HolidayUtil.isWorkDay(date,holidaysWithOutWeekends,isBroker,extraWorkDays);
    }
}
