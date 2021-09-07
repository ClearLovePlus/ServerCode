package com.chenhao.service.impl;

import com.chenhao.service.ITokenService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-5-27 13:09
 */
@Service("remoteTokenService")
public class RemoteTokenServiceImpl implements ITokenService {
    @Override
    public String createToken(Integer userId, String userName, String phoneNum) throws Exception {
        //todo 这里还没想好
        return "token";
    }
}
