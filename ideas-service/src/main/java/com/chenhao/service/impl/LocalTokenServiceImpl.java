package com.chenhao.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.constants.RedisKeyConstants;
import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dto.response.TokenResponseDTO;
import com.chenhao.service.IRedisClientService;
import com.chenhao.service.ITokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @description:本地生成登录令牌的一个实体类
 * @author: chenhao
 * @date: 2021-5-27 9:55
 */
@Service("localTokenService")
public class LocalTokenServiceImpl implements ITokenService {
    private static final Logger logger= LoggerFactory.getLogger(LocalTokenServiceImpl.class);
    private static final Integer EMPTY=0;
    @Autowired
    private IRedisClientService redisClient;
    @Override
    public String createToken(Integer userId, String userName, String phoneNum) throws Exception{
        if(userId==null||EMPTY.equals(userId)|| StringUtils.isEmpty(userName)){
            throw new BusinessException(BusinessEnum.MISSING_USER_ID_OR_USER_NAME);
        }
        UUID uuid = UUID.randomUUID();
        String result=uuid.toString().replace("-","");
        TokenResponseDTO tokenResponse=new TokenResponseDTO();
        tokenResponse.setToken(result);
        tokenResponse.setUserId(userId);
        redisClient.setNx(String.format(RedisKeyConstants.TOKEN_PREFIX,result), JSON.toJSONString(tokenResponse),(long)60*60*1000*24);
        return result;
    }
}
