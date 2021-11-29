package com.chenhao.web.controllers;

import com.chenhao.common.utils.RateLimiter;
import com.chenhao.common.utils.RateLimiterThread;
import com.chenhao.dto.BaseResponse;
import com.chenhao.dto.request.TestRequestDTO;
import com.chenhao.service.IRedisClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(tags = {"健康检查页"}, value = "健康检查页")
public class HeathController {
    private static final Logger logger = LoggerFactory.getLogger(HeathController.class);
    @Autowired
    private IRedisClientService redisClient;

    @RequestMapping(value = "health", method = RequestMethod.GET)
    @ApiOperation(value = "健康检查页")
    public String health() {
        redisClient.getRedisTemplate().opsForValue().set("test", "chenhao");
        String test = (String) redisClient.getRedisTemplate().opsForValue().get("test");
        redisClient.getRedisTemplate().opsForValue().getOperations().delete("test");
        logger.error("test error");
        logger.error("test error");
        return test;
    }

    @RequestMapping(value = "filedCheck", method = RequestMethod.POST)
    @ApiOperation(value = "filedTest")
    public BaseResponse filedCheckTest(@RequestBody TestRequestDTO request) {
        return new BaseResponse(0, "success");
    }

    @RequestMapping(value = "rate", method = RequestMethod.GET)
    @ApiOperation(value = "filedTest")
    public BaseResponse testRateLimiter(){
        RateLimiter rateLimiter=new RateLimiter(100,2,1000);
        RateLimiterThread thread=new RateLimiterThread(rateLimiter);
        thread.run();
        return new BaseResponse("success");
    }
}
