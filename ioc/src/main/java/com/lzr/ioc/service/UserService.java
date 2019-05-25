package com.lzr.ioc.service;

import com.lzr.ioc.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-05-25 16:35
 */
@Service("userService")
public class UserService {
    public void printUser(User user){
        System.out.println(user.toString());
    }
}
