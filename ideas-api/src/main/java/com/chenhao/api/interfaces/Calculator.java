package com.chenhao.api.interfaces;

import com.chenhao.api.request.AddRequest;

/**
 * 接口
 */
public interface Calculator {
    /**
     * rpc加法
     * @param request
     * @return
     */
    int add(AddRequest request);
}
