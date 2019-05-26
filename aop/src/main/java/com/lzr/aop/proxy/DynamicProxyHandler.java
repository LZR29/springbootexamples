package com.lzr.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author linzerong
 * @create 2019-05-26 0:10
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxy;

    public DynamicProxyHandler(Object proxy){
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.proxy.getClass().getSimpleName());
        System.out.println(this.proxy.hashCode());
        return method.invoke(this.proxy, args);
    }
}
