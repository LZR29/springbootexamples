package com.lzr.something.threadpool.controller;

import com.lzr.something.threadpool.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-01 22:38
 */
@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> test(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        System.out.println("请求线程名称:【" + Thread.currentThread().getName() + "】--" + new Date());
        asyncService.generator();
        return map;
    }
}
