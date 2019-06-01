package com.lzr.springmvc_deep.validator;

import com.lzr.springmvc_deep.bean.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**自定义的验证器,实现Validator接口
 * @author linzerong
 * @create 2019-05-31 20:07
 */
public class Validator implements org.springframework.validation.Validator {
    /**
     * 该验证器只支持验证User类，只有通过此方法的类才能被validate()函数验证
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    /**
     * 有这个验证器后，需要再控制器的方法上使用@InitBinder,绑定到WebDateBinder机制
     * @param o
     * @param errors
     */
    @Override
    public void validate(Object o, Errors errors) {
        //对象为空
        if(o == null){
            //直接在参数处报错，这样就不会进入控制器的方法
            errors.rejectValue("", null, "用户不能为空！");
            return;
        }
        //先转换成User
        User user = (User) o;
        if(StringUtils.isEmpty(user.getName())){
            //增加错误,第一个参数要跟Object类的字段名一样，目前我不清楚为什么，只是个菜鸡
            errors.rejectValue("name", null, "用户名不能为空！");
        }
    }
}
