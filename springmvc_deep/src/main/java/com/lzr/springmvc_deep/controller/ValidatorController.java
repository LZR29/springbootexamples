package com.lzr.springmvc_deep.controller;

import com.lzr.springmvc_deep.bean.User;
import com.lzr.springmvc_deep.bean.ValidatorBean;
import com.lzr.springmvc_deep.validator.Validator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**请求参数验证JSR-303验证，通过bean来验证（ValidatorBean）
 * @author linzerong
 * @create 2019-05-30 20:01
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    /**
     * 用来获取ValidatorBean的json类型数据，联合postman测试数据检验
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public ValidatorBean getValidator() throws ParseException {
        ValidatorBean bean = new ValidatorBean();
        bean.setId(null);
        bean.setDate(DateFormat.getDateInstance().parse("2019-05-29"));
        bean.setInteger(29);
        bean.setDoubleValue(29.99);
        bean.setEmile("email");
        bean.setRange(6666666L);
        bean.setSize("lzr");
        bean.setUser(new User());
        return bean;
    }


    /**
     * 解析验证参数错误，从get方法获取一个含有错误的bean的json数据，验证错误
     * @param bean @Valid表示要验证，@RequestBody json数据转换
     * @param errors 错误信息，由spring mvc通过验证后自动填充
     * @return
     */
    @RequestMapping("/validate")
    @ResponseBody
    public Map<String, Object> validate(
            @Valid @RequestBody ValidatorBean bean, Errors errors){
        Map<String, Object> map = new HashMap<>();
        List<ObjectError> objectErrors = errors.getAllErrors();
        for (ObjectError oe : objectErrors){
            String key = null;
            String msg = null;
            //字段错误
            if(oe instanceof FieldError){
                FieldError fieldError = (FieldError) oe;
                //获取错误验证的字段名
                key = fieldError.getField() + " (String)";
            }else {
                //非字段错误,获取对象名称
                key = oe.getObjectName() + " (Object)";
            }
            //错误信息
            msg = oe.getDefaultMessage();
            map.put(key, msg);
        }
        return map;
    }

    /**
     *注解的作用是在执行控制器方法前，处理器先执行有这个注解的方法，这时将WebDataBinder对象作为参数传入，
     * 然后用它来绑定自定义的验证器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //绑定验证器
        binder.setValidator(new Validator());
        //定义日期参数格式，参数不再需要@DateTimeFormat注解，最后的参数boolean表示是否允许为空
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    /**
     *
     * @param user -- 通过自定义的转换器转换成对象（StringToUserConverter）
     * @param errors -- 验证器返回的错误
     * @param date  --  因为WebDateBinder已经绑定了格式，所以不需要注解
     * @return
     */
    @ResponseBody
    @RequestMapping("/uservalidate")
    public Map<String, Object> userValidate(@Valid User user, Errors errors, Date date){
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        //判断是否存在错误
        if(errors.hasErrors()){
            //获取全部错误
            List<ObjectError> objectErrors = errors.getAllErrors();
            for (ObjectError oe : objectErrors){
                String key = null;
                String msg = null;
                //字段错误
                if(oe instanceof FieldError){
                    FieldError fieldError = (FieldError) oe;
                    //获取错误验证的字段名
                    key = fieldError.getField();
                }else {
                    //非字段错误,获取对象名称
                    key = oe.getObjectName() + " (Object)";
                }
                //错误信息
                msg = oe.getDefaultMessage();
                map.put(key, msg);
            }
        }
        return map;
    }
}
