package com.lzr.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-05-26 23:48
 * @Order注解用来排序切面，值越小，优先级越高
 */
@Component
@Aspect
@Order(3)
public class Aspect1 {

    @Pointcut("execution(* com.lzr.aop.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects(){}

    @Before("manyAspects()")
    public void before(){
        System.out.println("Aspect1 before......");
    }
    @After("manyAspects()")
    public void after(){
        System.out.println("Aspect1 after......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning(){
        System.out.println("Aspect1 afterReturning......");
    }
}
