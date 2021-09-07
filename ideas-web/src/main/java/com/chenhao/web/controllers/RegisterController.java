package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.RegisterRequestDTO;
import com.chenhao.dto.response.RegisterResponseDTO;
import com.chenhao.service.ISmsRegisterService;
import com.chenhao.service.IUserNameRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:登录接口
 * @author: chenhao
 * @date: 2021-6-2 15:56
 */
@RestController
@RequestMapping("register")
@Api(value = "blog注册接口",tags ={"blog注册接口"} )
@Slf4j
public class RegisterController {
    @Autowired
    private ISmsRegisterService smsRegisterService;
    @Autowired
    private IUserNameRegisterService userNameRegisterService;

    @RequestMapping(value = "userName", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("用户名注册")
    public BaseResponse<RegisterResponseDTO> registerByPwd(@RequestBody RegisterRequestDTO request) throws Exception {
        BaseResponse<RegisterResponseDTO> result=new BaseResponse<>();
        result.setData(userNameRegisterService.registerByUserName(request));
        return result;
    }
}
