package com.chenhao.api;

import com.chenhao.api.interfaces.Calculator;
import com.chenhao.api.provider.CalculatorImpl;
import com.chenhao.api.proxy.DefaultProxy;
import com.chenhao.api.request.AddRequest;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-26 14:28
 */
public class test {

    public static void main(String[] args) {
        DefaultProxy proxy=new DefaultProxy();
        AddRequest request=new AddRequest();
        request.setVar1(1);
        request.setVar2(10);
        Calculator bind = (Calculator) proxy.bind(new CalculatorImpl());
        int add = bind.add(request);
        System.out.println(add);
    }
}
