package com.chenhao.rpc.serialize;

/**
 * @description:序列化和反序列化工具
 * @author: chenhao
 * @date: 2022-2-7 14:55
 */
public abstract class Serialize {
    /**
     * 序列化
     * @param object
     * @param <T>
     * @return
     */
    public abstract <T> byte[] serialize(T object);

    /**
     * 反序列化工具
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    public abstract <T> Object deserialize(byte[]bytes,Class<T>clazz);
}
