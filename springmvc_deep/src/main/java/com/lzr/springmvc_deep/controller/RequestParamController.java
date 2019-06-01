package com.lzr.springmvc_deep.controller;

import com.lzr.springmvc_deep.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-05-29 16:11
 */
@Controller
@RequestMapping("/request")
public class RequestParamController {

    /**
     *在无注解下获取参数，要求参数名称要与http请求参数名称一致
     * @param int_val
     * @param long_val
     * @param str
     * @return
     */
    @GetMapping("/noannotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer int_val, Long long_val, String str){
        Map<String, Object> map = new HashMap<>();
        map.put("int", int_val);
        map.put("long", long_val);
        map.put("string", str);
        return map;
    }

    /**
     * 使用注解获取参数，
     * @param int_val
     * @param long_val
     * @param str
     * @return
     */
    @ResponseBody
    @GetMapping("/annotation")
    public Map<String ,Object> annotation(
            @RequestParam("int_val") Integer int_val,
            @RequestParam("long_val") Long long_val,
            @RequestParam(value = "str",required = false) String str){
        Map<String, Object> map = new HashMap<>();
        map.put("int", int_val);
        map.put("long", long_val);
        map.put("string", str);
        return map;
    }

    /**
     * 传递数组
     * http://localhost:8080/request/array?intArr=1,2,3&longArr=233,45,6&strArr=lzr,lzz
     * @param intArr
     * @param longArr
     * @param strArr
     * @return
     */
    @ResponseBody
    @GetMapping("/array")
    public Map<String, Object> array(
            @RequestParam("intArr") int[] intArr,
            @RequestParam("longArr") Long[] longArr,
            @RequestParam("strArr") String[] strArr){
        Map<String, Object> map = new HashMap<>();
        map.put("intArr", intArr);
        map.put("longArr", longArr);
        map.put("stringArr", strArr);
        return map;
    }

    /**
     * 获取一个User的json格式用来在postman测试传递json
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    public User get(){
        User user = new User();
        user.setId(1L);
        user.setName("lzr");
        user.setNote("json");
        return user;
    }

    /**
     * 传递json，@RequestBody会转换成对象
     * @param user
     * @return
     */
    @PostMapping("/json")
    @ResponseBody
    public User json(@RequestBody User user){
        user.setNote("经过json函数！！");
        return user;
    }

    /**
     * 通过注解@PathVariable和url中的{..}确定一个参数
     * @param param
     * @return
     */
    @GetMapping("/url/{param}")
    @ResponseBody
    public Map<String, Object> urlParam(@PathVariable("param") String param){
        Map<String, Object> map = new HashMap<>();
        map.put("param", param);
        return map;
    }

    /**
     * 获取格式化参数，日期格式可以在配置文件配置：spring.mvc.date-format=yyyy-MM-dd
     * @param date
     * @param number
     * @return
     */
    @GetMapping("/format")
    @ResponseBody
    public Map<String, Object> format(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("date") Date date,
            @NumberFormat(pattern = "#,###.##") @RequestParam("num") Double number){
        Map<String, Object> map = new HashMap<>();
        map.put("date",date);
        map.put("num",number);
        return map;
    }
}
