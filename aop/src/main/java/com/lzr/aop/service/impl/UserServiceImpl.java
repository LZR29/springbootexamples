package com.lzr.aop.service.impl;

import com.lzr.aop.bean.User;
import com.lzr.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-05-26 22:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("用户为空!!!!");
        }
        System.out.println(user.toString());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面！！！！");
    }


}
