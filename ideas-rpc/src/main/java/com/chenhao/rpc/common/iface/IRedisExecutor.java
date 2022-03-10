package com.chenhao.rpc.common.iface;

import com.chenhao.rpc.common.RedisResultContent;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-3-10 13:44
 */
public interface IRedisExecutor {

    /**
     * 执行redis操作的逻辑
     * @param caller
     * @return
     */
    void exec(ICallerInterface caller);
}
