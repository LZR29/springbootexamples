package com.lzr.springmvc_deep.controller;

import com.lzr.springmvc_deep.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author linzerong
 * @create 2019-05-29 17:32
 */
@Controller
@RequestMapping("/converter")
public class ConverterController {
    /**
     * 通过自定义的转换器，把字符串装换成user
     * @param user
     * @return
     */
    @GetMapping("/stringtouser")
    @ResponseBody
    public User stringToUser(@RequestParam("user") User user){
        return user;
    }

    /**
     * 通过自定义的转换器，把字符串转成成user集合，当然这个字符串是能拆分成多个user的
     * @param users
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<User> list(@RequestParam("users") List<User> users){
        return users;
    }

}
