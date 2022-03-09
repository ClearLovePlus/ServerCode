package com.chenhao.rpc.register.impl;

import com.chenhao.rpc.register.Register;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: 基于数据库的注册中心
 * @author: chenhao
 * @date: 2022-1-19 16:59
 */
public class DbRegister extends Register {
    @Override
    public void start(Map<String, String> parameters) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void register(Set<String> key, String value) {

    }

    @Override
    public void remove(Set<String> key, String value) {

    }

    @Override
    public Map<String, TreeSet<String>> discovery(Set<String> key) {
        return null;
    }

    @Override
    public TreeSet<String> discovery(String key) {
        return null;
    }
}
