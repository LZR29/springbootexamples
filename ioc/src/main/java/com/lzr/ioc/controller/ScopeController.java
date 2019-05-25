package com.lzr.ioc.controller;

import com.lzr.ioc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-05-25 22:47
 */
@RestController
@RequestMapping("/scope")
public class ScopeController {

    @Autowired
    private User user;

    @Autowired
    private User user2;

    @RequestMapping("/request")
    public void scope(){
        System.out.println(user == user2);
    }
}
