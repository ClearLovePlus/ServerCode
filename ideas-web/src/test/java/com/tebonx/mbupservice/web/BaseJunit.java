package com.tebonx.mbupservice.web;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 基础测试类
 *
 * @author chenhao
 * @Date 2017/5/21 16:10
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MbupServiceApplication.class)
@WebAppConfiguration
//@Transactional //打开的话测试之后数据可自动回滚
public class BaseJunit {

    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;


    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testUserInfo() throws Exception{
//        List<UserDetailInfo> allUserInfo = cleanGovernmentService.getAllUserInfo();
//        System.out.println(JSON.toJSONString(allUserInfo));
    }

}

