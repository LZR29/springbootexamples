package com.lzr.something.activemq.controller;

import com.lzr.something.activemq.bean.User;
import com.lzr.something.activemq.service.ActiveMqService;
import com.lzr.something.activemq.service.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-02 15:10
 */
@Controller
@RequestMapping("/activemq")
public class ActiveMqController {

    @Autowired
    private ActiveMqService activeMqService;

    @Autowired
    private ActiveMqUserService activeMqUserService;

    @GetMapping("/msg")
    @ResponseBody
    public Map<String, Object> msg(@RequestParam("msg") String msg){
        activeMqService.sendMsg(msg);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(){
        User user = new User();
        Map<String, Object> map = new HashMap<>();
        user.setId(1L);
        user.setName("lzr");
        user.setNote("activemq_user");
        activeMqUserService.sendMsg(user);
        map.put("success", true);
        return map;
    }
}
