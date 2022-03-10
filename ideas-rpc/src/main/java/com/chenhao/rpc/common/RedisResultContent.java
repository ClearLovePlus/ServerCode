package com.chenhao.rpc.common;

/**
 * @description: 由于java并不能修改闭包外的对象信息，所以需要一个对象持有返回对象的值
 * @author: chenhao
 * @date: 2022-3-10 13:41
 */
public class RedisResultContent<T> {
    private T value;

    public RedisResultContent(){

    }
    public RedisResultContent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
