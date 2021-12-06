package com.chenhao.api.provider;

import com.chenhao.api.interfaces.Calculator;
import com.chenhao.api.request.AddRequest;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(AddRequest request) {
        return request.getVar1()+request.getVar2();
    }
}
