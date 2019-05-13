package com.lzr.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoor linzerong
 * @create 2019-05-13 14:28
 */
@RestController()
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
