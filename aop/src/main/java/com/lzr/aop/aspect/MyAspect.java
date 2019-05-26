package com.lzr.aop.aspect;

import com.lzr.aop.aspect.validator.UserValidator;
import com.lzr.aop.aspect.validator.impl.UserValidatorImpl;
import com.lzr.aop.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author linzerong
 * @create 2019-05-26 22:06
 */
@Aspect
public class MyAspect {

    @DeclareParents(value = "com.lzr.aop.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.lzr.aop.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){}


    //@Before("execution(* com.lzr.aop.service.impl.UserServiceImpl.printUser(..))")
    @Before("pointCut() && args(user)")
    public void before(JoinPoint point, User user){
        Object[] objects = point.getArgs();
        System.out.println("user.........");
        System.out.println(user.toString());
        System.out.println("object.......");
        System.out.println(objects[0].toString());
        System.out.println("before.......");
    }

    //@After("execution(* com.lzr.aop.service.impl.UserServiceImpl.printUser(..))")
    @After("pointCut()")
    public void after(){
        System.out.println("after........");
    }

    //@AfterReturning("execution(* com.lzr.aop.service.impl.UserServiceImpl.printUser(..))")
    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning......");
    }

   //@AfterThrowing("execution(* com.lzr.aop.service.impl.UserServiceImpl.printUser(..))")
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around before......");
        //回调对象的方法
        point.proceed();
        System.out.println("around after.......");
    }




}
