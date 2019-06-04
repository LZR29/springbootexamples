package com.lzr.webflux.config;

import com.lzr.webflux.bean.User;
import com.lzr.webflux.enumeration.SexEnum;
import com.lzr.webflux.validator.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**转换器，把字符串转换成user对象
 * @author linzerong
 * @create 2019-06-04 8:50
 */
@Configuration
public class WebFluxConfig implements WebFluxConfigurer{


    /**
     * 定义string转化成user的转化器
     * id-userName-0/1-note
     */
    @Bean
    public Converter<String, User> stringToUserConverter(){
        Converter<String, User> converter = new Converter<String, User>() {
            @Override
            public User convert(String s) {
                User user = new User();
                String[] param = s.split("-");
                Long id = Long.valueOf(param[0]);
                user.setId(id);
                user.setUserName(param[1]);
                int code = Integer.valueOf(param[2]);
                SexEnum sexEnum = SexEnum.getSexEnum(code);
                user.setSex(sexEnum);
                user.setNote(param[3]);
        //        System.out.println(user.getId()+user.getUserName()+user.getSex()+user.getNote()+"!!!!!!");
                return user;
            }
        };
        return converter;
    }

    /*@Override
    public Validator getValidator() {
        return new UserValidator();
    }*/
}
