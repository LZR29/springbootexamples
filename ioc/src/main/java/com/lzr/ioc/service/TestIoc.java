package com.lzr.ioc.service;

import com.lzr.ioc.bean.User;
import com.lzr.ioc.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linzerong
 * @create 2019-05-25 16:40
 */
public class TestIoc {


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) ctx.getBean("user");
        System.out.println(user.toString());
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService.hashCode());
    }
}
