package com.lzr.webflux.controller;

import com.lzr.webflux.bean.User;
import com.lzr.webflux.enumeration.SexEnum;
import com.lzr.webflux.service.UserService;
import com.lzr.webflux.validator.UserValidator;
import com.lzr.webflux.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author linzerong
 * @create 2019-06-03 23:36
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 把User转化成UserVo(bean对象->视图对象)
     * @param user
     * @return
     */
    private UserVo translate(User user){
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setNote(user.getNote());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        return userVo;
    }

    @RequestMapping("/insert/{user}")
    public Mono<UserVo> insertUser(@Valid @PathVariable("user") User user){
        return userService.insertUser(user).
                //把user转化成uservo对象
                map(u -> translate(u));
    }

    @RequestMapping("/get/{id}")
    public Mono<UserVo> getUser(@PathVariable() Long id){
        return userService.getUser(id).map(u -> translate(u));
    }

    @RequestMapping("/update/{id}")
    public Mono<UserVo> updateUser(@PathVariable() Long id){
        User user = new User();
        user.setId(id);
        user.setNote("note_" + id + "_" + id);
        user.setUserName("lzr_"  + id + "_" + id);
        user.setSex(SexEnum.FEMALE);
        return userService.updateUser(user).map(u -> translate(u));
    }

    @RequestMapping("/delete/{id}")
    public Mono<Void> deleteUser(@PathVariable() Long id){
        return userService.deleteUser(id);
    }

    @RequestMapping("/find/{userName}/{note}")
    public Flux<UserVo> findUsers(@PathVariable String userName, @PathVariable String note){
        return userService.findUsers(userName, note).map(u -> translate(u));
    }

    @InitBinder
    public void initBinder(DataBinder binder){
        binder.setValidator(new UserValidator());
    }
}
