package com.lzr.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author linzerong
 * @create 2019-06-03 12:15
 */
@Configuration
public class WebSocketConfig {

    /**
     * 创建服务站点
     */

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
