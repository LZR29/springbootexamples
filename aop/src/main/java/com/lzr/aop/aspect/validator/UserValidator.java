package com.lzr.aop.aspect.validator;

import com.lzr.aop.bean.User;

public interface UserValidator {
    /**
     * 检测用户是否为空
     * @param user
     * @return
     */
    boolean validate(User user);
}
