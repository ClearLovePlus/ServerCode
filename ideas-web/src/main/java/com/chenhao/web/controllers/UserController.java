package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.ChangeRequestDTO;
import com.chenhao.dto.response.UserInfoResponse;
import com.chenhao.service.IUserService;
import com.chenhao.web.annotions.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @description:用户信息接口
 * @author: chenhao
 * @date: 2021-10-15 13:13
 */
@RestController
@RequestMapping("user")
@Api(value = "修改用户信息相关", tags = {"用户信息服务"})
public class UserController {

    @Autowired
    private IUserService userService;

    @Log
    @ApiOperation("修改用户信息")
    @RequestMapping(value = "change", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse<Boolean> changeUserInfo(@RequestBody ChangeRequestDTO request) throws Exception {
        return new BaseResponse<>(userService.changeUserInfo(request));
    }

    @Log
    @ApiOperation("查询用户信息")
    @RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse<UserInfoResponse> getUserInfo(@RequestParam(value = "userId") Integer userId) throws Exception {
        return new BaseResponse<>(userService.getUserInfo(userId));
    }
}
