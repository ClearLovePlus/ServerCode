package com.chenhao.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-1-5 16:09
 */
@RestController("api/v1")
@Api(tags = {"健康检查页"})
public class HeathController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping(value = "health",method = RequestMethod.GET)
    @ApiOperation(value = "健康检查页")
    public String health(){
        stringRedisTemplate.opsForValue().set("test","chenhao");
        String test=stringRedisTemplate.opsForValue().get("test");
        stringRedisTemplate.opsForValue().getOperations().delete("test");
        return test;
    }
}
