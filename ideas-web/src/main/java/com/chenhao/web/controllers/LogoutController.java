package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.service.ILoginWithPwdService;
import com.chenhao.web.annotions.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:登出接口
 * @author: chenhao
 * @date: 2021-9-16 15:25
 */
@RestController
@RequestMapping("logout")
@Api(value = "通用的登出",tags = {"登出服务"})
public class LogoutController {

    @Autowired
    private ILoginWithPwdService loginWithPwdService;
    @ApiOperation("登出服务")
    @Log
    @RequestMapping(value = "out",method = RequestMethod.GET)
    @ResponseBody
    BaseResponse<Boolean> logout(@RequestParam("userId") Integer userId){
        return new BaseResponse<>(loginWithPwdService.logout(userId));
    }
}
