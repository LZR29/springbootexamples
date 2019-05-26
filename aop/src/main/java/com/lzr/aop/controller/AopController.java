package com.lzr.aop.controller;

import com.lzr.aop.aspect.validator.UserValidator;
import com.lzr.aop.bean.User;
import com.lzr.aop.service.UserService;
import com.lzr.aop.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linzerong
 * @create 2019-05-26 22:18
 */
@RestController
@RequestMapping("/user")
public class AopController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserService2 userService2;

    @RequestMapping("/print")
    public User printUser(Long id, String name,String note){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setNote(note);
     //   userService.printUser(null);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    public User validateAndPrint(Long id, String name,String note){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setNote(note);
        UserValidator userValidator = (UserValidator) userService;
        if(userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @RequestMapping("/cglib")
    public User printUserCGLIB(Long id, String name,String note){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setNote(note);
        userService2.printUser(user);
        return user;
    }

    @RequestMapping("/manyaspects")
    public String manyAspects(){
        userService.manyAspects();
        return "manyaspects";
    }
}
