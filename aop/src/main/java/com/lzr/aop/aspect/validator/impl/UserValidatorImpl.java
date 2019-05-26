package com.lzr.aop.aspect.validator.impl;

import com.lzr.aop.aspect.validator.UserValidator;
import com.lzr.aop.bean.User;

/**
 * @author linzerong
 * @create 2019-05-26 22:57
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
