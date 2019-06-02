package com.lzr.something.activemq.service.impl;

import com.lzr.something.activemq.service.ActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**ActiveMq服务实现类
 * @author linzerong
 * @create 2019-06-02 14:46
 */
@Service
public class ActiveMqServiceImpl implements ActiveMqService {
    /**
     * 由spring boot自动注入
     */
    @Autowired
    private JmsTemplate jmsTemplate;
    private final  String dest = "myDest";
    /**
     * 发送消息
     * @param msg
     */
    @Override
    public void sendMsg(String msg) {
        System.out.println("【发送消息："+ msg+ "】");
        jmsTemplate.convertAndSend(dest,msg);
        //自定义发送地址
        //jmsTemplate.convertAndSend("目的地址",msg);
    }

    /**
     * 接收消息，通过注解监听地址发送来的消息
     * @param msg
     */
    @Override
    @JmsListener(destination = "myDest")
    public void receiveMsg(String msg) {
        System.out.println("【接收消息："+ msg +"】");
    }
}
