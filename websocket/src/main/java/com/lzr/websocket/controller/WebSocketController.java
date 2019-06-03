package com.lzr.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author linzerong
 * @create 2019-06-03 12:49
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
