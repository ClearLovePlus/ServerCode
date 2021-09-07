package com.chenhao.web.controllers;

import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.TestRequestDTO;
import com.chenhao.service.IRedisClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-1-5 16:09
 */
@RestController("api/v1")
@Api(tags = {"健康检查页"},value = "健康检查页")
public class HeathController {

    @Autowired
    private IRedisClientService redisClient;
    @RequestMapping(value = "health",method = RequestMethod.GET)
    @ApiOperation(value = "健康检查页")
    public String health(){
        redisClient.getRedisTemplate().opsForValue().set("test1","chenhao");
        String test=(String)redisClient.getRedisTemplate().opsForValue().get("test1");
        redisClient.getRedisTemplate().opsForValue().getOperations().delete("test1");
        return test;
    }
    @RequestMapping(value = "filedCheck",method = RequestMethod.POST)
    @ApiOperation(value = "filedTest")
    public BaseResponse filedCheckTest(@RequestBody TestRequestDTO request){
        return new BaseResponse(0,"success");
    }
}
