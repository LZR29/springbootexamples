package com.lzr.aop.proxy;

/**
 * @author linzerong
 * @create 2019-05-26 0:08
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("--------------- Hello，" + name + "--------------");
    }
}
