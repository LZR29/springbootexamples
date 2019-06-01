package com.lzr.springmvc_deep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-01 13:26
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/start")
    @ResponseBody
    public Map<String, Object> start(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        System.out.println("执行处理器逻辑");
        return map;
    }

    /**
     *执行结果是根据责任链模式的规则，对于处理器前方法都会先注册先执行，而处理器后方法和完成方法都是先注册后执行.
     * 当然这些拦截器都是处理器前方法返回true的结果。想测试返回为false的结果，你可更改拦截器2的方法让它返回false。
     * 你可以看到，处理器前的方法依然是先注册先执行，但是一旦有某个拦截器的处理器前方法返回false，后续的拦截器和处理器
     * 还有所有拦截器的处理器后方法都不会执行，而处理器完成方法会被执行只有那些处理器前返回为true的拦截器。
     * @return
     */
    @RequestMapping("/muliti")
    @ResponseBody
    public Map<String, Object> mulitiInterceptor(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        System.out.println("执行处理器逻辑");
        return map;
    }
}
