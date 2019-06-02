package com.lzr.something.rabbitmq.controller;

import com.lzr.something.rabbitmq.bean.User;
import com.lzr.something.rabbitmq.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-02 22:21
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitmqController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @GetMapping("/msg")
    @ResponseBody
    public Map<String, Object> msg(){
        rabbitmqService.sendMsg("msg!!!");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(){
        User user = new User();
        user.setId(1L);
        user.setName("lzr");
        user.setNote("note");
        rabbitmqService.sendUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
