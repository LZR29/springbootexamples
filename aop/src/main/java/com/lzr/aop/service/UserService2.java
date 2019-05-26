package com.lzr.aop.service;

import com.lzr.aop.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-05-26 23:43
 * 这个是无接口的类，测试使用cglib代理
 */
@Service
public class UserService2 {
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("用户为空!!!!");
        }
        System.out.println(user.toString());
    }
}
