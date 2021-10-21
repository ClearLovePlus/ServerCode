package com.chenhao.service.impl;

import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.common.utils.HolidayUtil;
import com.chenhao.common.utils.MD5Util;
import com.chenhao.dao.entity.User;
import com.chenhao.dao.entity.UserExample;
import com.chenhao.dao.mapper.UserMapper;
import com.chenhao.dto.request.ChangePwdRequestDTO;
import com.chenhao.dto.request.ChangeRequestDTO;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.UserInfoResponse;
import com.chenhao.service.IUserService;
import com.chenhao.service.config.HolidayConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户信息管理
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
        UserExample example = new UserExample();
        //根据用户名和有效状态查询用户信息
        example.createCriteria().andUsernameEqualTo(userName).andIsActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)) {
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
        User user = new User();
        user.setUsername(request.getUserName());
        user.setPhone(request.getPhoneNum());
        user.setPassword(MD5Util.encode(request.getPassword()));
        user.setIsActive(1);
        user.setAvatarimgurl("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public User getUserByPhoneNum(String phoneNum) {
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phoneNum).andIsActiveEqualTo(1);
        List<User> users = userMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(users)) {
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
        List<String> holidaysWithOutWeekends = Arrays.asList(config.getHolidaysWithOutWeekends().split(","));
        List<String> extraWorkDays = Arrays.asList(config.getExtraWorkDays().split(","));
        return HolidayUtil.isWorkDay(date, holidaysWithOutWeekends, isBroker, extraWorkDays);
    }

    @Override
    public Boolean changeUserInfo(ChangeRequestDTO request) throws Exception {
        if(request==null || request.getUserId()==null||request.getUserId()==0){
            throw new BusinessException(BusinessEnum.MISSING_USER_ID_OR_USER_NAME);
        }
        User user = userMapper.selectByPrimaryKey(request.getUserId());
        if (user == null) {
            throw new BusinessException(BusinessEnum.NO_RECORD);
        }
        if (StringUtils.isNotEmpty(request.getAvatarUrl())) {
            user.setAvatarimgurl(request.getAvatarUrl());
        }
        if (StringUtils.isNotEmpty(request.getUserName())) {
            user.setUsername(request.getUserName());
        }
        if (StringUtils.isNotEmpty(request.getEmail())) {
            user.setEmail(request.getEmail());
        }
        if (request.getSex() != null && request.getSex() > 0) {
            user.setGender(request.getSex() == 1 ? "男" : "女");
        }
        if (StringUtils.isNotEmpty(request.getDescription())) {
            user.setPersonalbrief(request.getDescription());
        }
        return userMapper.updateByPrimaryKeyWithBLOBs(user) > 0;
    }

    @Override
    public UserInfoResponse getUserInfo(Integer userId) throws Exception {
        if(userId==null||userId==0){
            throw new BusinessException(BusinessEnum.MISSING_USER_ID_OR_USER_NAME);
        }
        User userByUserId = this.getUserByUserId(userId);
        if(userByUserId==null){
            throw new BusinessException(BusinessEnum.NO_RECORD);
        }
        UserInfoResponse response=new UserInfoResponse();
        response.setUserId(userByUserId.getId());
        response.setAvatarUrl(userByUserId.getAvatarimgurl());
        response.setUserName(userByUserId.getUsername());
        response.setTrueName(userByUserId.getTruename());
        response.setSex("男".equals(userByUserId.getGender())?1:2);
        response.setPhone(userByUserId.getPhone());
        response.setDescription(userByUserId.getPersonalbrief());
        response.setEmail(userByUserId.getEmail());
        return response;
    }
}
