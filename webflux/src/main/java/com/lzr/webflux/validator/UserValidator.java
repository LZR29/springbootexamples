package com.lzr.webflux.validator;

import com.lzr.webflux.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author linzerong
 * @create 2019-06-04 10:03
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if(StringUtils.isEmpty(user.getUserName())){
            errors.rejectValue("userName", null, "用户名不能为空");
            System.out.println("出现错误！！！");
        }
    }
}
