package com.tebonx.mbupservice.web;

import com.alibaba.fastjson.JSON;
import com.chenhao.service.IRedisClientService;
import com.chenhao.service.IUserService;
import com.chenhao.web.BlogApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * 基础测试类
 *
 * @author chenhao
 * @Date 2017/5/21 16:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
@WebAppConfiguration
//@Transactional //打开的话测试之后数据可自动回滚
public class BaseJunit {

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRedisClientService redisClient;

    protected MockMvc mockMvc;


    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testUserInfo() throws Exception{
//        Assert.assertTrue(userService.isHoliday(true,"2021-07-07"));
//        Assert.assertFalse(userService.isHoliday(true,"2021-02-07"));
//        Assert.assertTrue(userService.isHoliday(false,"2021-07-07"));
//        Assert.assertTrue(userService.isHoliday(false,"2021-02-07"));
//        Assert.assertFalse(userService.isHoliday(true,"2021-10-01"));
//        Assert.assertFalse(userService.isHoliday(false,"2021-10-01"));
        RedisTemplate<String, Object> redisTemplate = redisClient.getRedisTemplate();
        redisTemplate.opsForValue().set("test","test");
        System.out.println(redisTemplate.opsForValue().get("redisKey"));
    }

    @Test
    public void RedisLockTest() throws Exception{
        String content=UUID.randomUUID().toString();
//        for (int i=0;i<2;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
                    try {
                        if(redisClient.tryLock("redisKey", content,5L, TimeUnit.SECONDS)){
                            System.out.println(Thread.currentThread().getId()+"--"+Thread.currentThread().getName()+"获得redis锁");
                        }
                    }catch (Exception e){
                        System.out.println("error");
                    }finally {
                        redisClient.releaseLock("redisKey",content);
                        System.out.println(Thread.currentThread().getId()+"--"+Thread.currentThread().getName()+"释放redis锁");
                    }
//                }}).start();
        }
//    }

}

