package com.lzr.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author linzerong
 * @create 2019-05-28 9:10
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/test")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
