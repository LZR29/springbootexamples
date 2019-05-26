package com.lzr.aop.proxy;

import java.lang.reflect.Proxy;

/**
 * @author linzerong
 * @create 2019-05-26 0:13
 * java的动态代理
 */
public class Test {
    public static void test(HelloService service){
        service.sayHello("lzr");
    }

    public static void main(String[] args) {
        HelloService serviceImpl = new HelloServiceImpl();
        HelloServiceImpl helloService = new HelloServiceImpl();
        test(serviceImpl);
        System.out.println(serviceImpl.hashCode());
        System.out.println("#######################");
        HelloService service = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                new Class[]{HelloService.class}, new DynamicProxyHandler(helloService));
        test(service);
        System.out.println(helloService.hashCode());
    }
}
