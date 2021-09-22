package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.LoginRequestDTO;
import com.chenhao.dto.response.LoginResponseDTO;
import com.chenhao.service.ILoginWithPwdService;
import com.chenhao.web.annotions.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-18 16:48
 */
@RestController
@RequestMapping("login")
@Api(value = "登录接口", tags = {"blog登录"})
public class LoginController {
    @Autowired
    private ILoginWithPwdService loginWithPwdService;

    @Log
    @RequestMapping(value = "userName", method = RequestMethod.POST)
    @ApiOperation("登录接口")
    @ResponseBody
    BaseResponse<LoginResponseDTO> loginWithUserName(@RequestBody LoginRequestDTO request) throws Exception {
        LoginResponseDTO responseDTO = loginWithPwdService.loginWithPwd(request);
        return new BaseResponse<>(responseDTO);
    }
}
