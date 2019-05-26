package com.lzr.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-05-26 23:48
 */
@Component
@Aspect
@Order(2)
public class Aspect2 {
    @Pointcut("execution(* com.lzr.aop.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects(){}

    @Before("manyAspects()")
    public void before(){
        System.out.println("Aspect2 before......");
    }
    @After("manyAspects()")
    public void after(){
        System.out.println("Aspect2 after......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning(){
        System.out.println("Aspect2 afterReturning......");
    }
}
