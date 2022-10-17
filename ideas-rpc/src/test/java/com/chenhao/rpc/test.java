package com.chenhao.rpc;

import com.chenhao.rpc.common.SingleRedisClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-9 16:17
 */
public class test {
    public static void main(String[] args) {
        SingleRedisClient client=new SingleRedisClient();
        //get set test
//        client.set("chen","1");
//        client.set("hao","2");
//        String chen = client.get("chen");
//        String hao = client.get("hao");
//        System.out.println(chen+hao);
        String key="testList";
        List<String>  testData=new ArrayList<>();
        for(int i=0;i<10;i++){
            testData.add(String.valueOf(i));
        }
        client.lPushAll(key,testData);
        List<String> strings = client.lRange(key, 0L, -1L);
        System.out.println(strings);
    }
}
