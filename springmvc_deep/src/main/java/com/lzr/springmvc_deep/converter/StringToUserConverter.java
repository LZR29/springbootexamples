package com.lzr.springmvc_deep.converter;

import com.lzr.springmvc_deep.bean.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-05-29 17:33
 * 把字符串自动转换成user，spring会自动注册到转换机制
 * 字符串格式为：{id}-{userName}-{note}
 */
@Component
public class StringToUserConverter implements Converter<String, User> {
    @Override
    public User convert(String s) {
        User user = new User();
        //分割字符串
        String param[] = s.split("-");
        user.setId(Long.parseLong(param[0]));
        user.setName(param[1]);
        user.setNote(param[2]);
        return user;
    }
}
