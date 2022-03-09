package com.chenhao.rpc.serialize;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-2-7 15:29
 */
public class FastJsonSerializer extends Serialize{
    @Override
    public <T> byte[] serialize(T object) {
        return new byte[0];
    }

    @Override
    public <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        return null;
    }
}
