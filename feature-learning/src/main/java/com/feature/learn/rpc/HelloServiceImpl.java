package com.feature.learn.rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "当前线程: "+Thread.currentThread().getName()+" ---> hello:" + name;
    }
}