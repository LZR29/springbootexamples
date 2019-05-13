package com.lzr.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoor linzerong
 * @create 2019-05-13 15:37
 */
@RestController
public class MyConfigController {

    /**
     * 需要读取配置文件的值只需要加@Value(“${属性名}”)：
     */
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;


    /**
     * get方式请求
     * @return
     */
    @GetMapping("/myconfig")
    public String myConfig(){
        return "姓名:" + name + "，年龄:" + age;
    }

}
