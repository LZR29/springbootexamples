package com.lzr.config.controller;

import com.lzr.config.bean.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoor linzerong
 * @create 2019-05-13 15:51
 * 需要在应用类或者application类，加EnableConfigurationProperties注解。
 */
@RestController
@EnableConfigurationProperties(MyConfig.class)
public class MyConfigBeanController {
    @Autowired
    private MyConfig myConfig;

    /**
     * get方式请求
     * @return
     */
    @GetMapping("/myconfigbean")
    public String myConfig(){
        return myConfig.toString();
    }
}
