package com.lzr.ioc.config;

import com.lzr.ioc.bean.User;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-05-25 16:31
 */
@Configuration
//excludeFilters不扫描符合条件的包
@ComponentScan(value = "com.lzr.ioc.*",excludeFilters = {@ComponentScan.Filter(classes = Service.class)})
//@ComponentScan(basePackages = "com.lzr.ioc.bean")
//@ComponentScan(basePackageClasses = {User.class})
public class AppConfig {
    //initMethod和destroyMethod都是bean的方法
    //@Bean(initMethod = "",destroyMethod = "")
    public User getUser(){
        return new User();
    }
}
