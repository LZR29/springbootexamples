package com.lzr.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-05-26 23:48
 */
@Aspect
@Component
@Order(1)
public class Aspect3 {
    @Pointcut("execution(* com.lzr.aop.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects(){}

    @Before("manyAspects()")
    public void before(){
        System.out.println("Aspect3 before......");
    }
    @After("manyAspects()")
    public void after(){
        System.out.println("Aspect3 after......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning(){
        System.out.println("Aspect3 afterReturning......");
    }
}
