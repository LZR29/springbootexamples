package com.lzr.config.controller;

import com.lzr.config.bean.CustomizeBean;
import com.lzr.config.bean.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoor linzerong
 * @create 2019-05-13 16:13
 */
@RestController
@EnableConfigurationProperties(CustomizeBean.class)
public class CustomizeBeanController {
    @Autowired
    private CustomizeBean customizeBean;

    /**
     * get方式请求
     * @return
     */
    @GetMapping("/customizebean")
    public String myConfig(){
        return customizeBean.toString();
    }
}
