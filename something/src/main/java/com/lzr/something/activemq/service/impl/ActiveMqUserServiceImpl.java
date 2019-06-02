package com.lzr.something.activemq.service.impl;

import com.lzr.something.activemq.bean.User;
import com.lzr.something.activemq.service.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-06-02 19:45
 */
@Service
public class ActiveMqUserServiceImpl implements ActiveMqUserService {

    @Autowired
    private JmsTemplate jmsTemplate;
    private final  String dest = "myUser";

    /**
     * 想要发送对象需要配置activemq信任user类
     * @param user
     */
    @Override
    public void sendMsg(User user) {
        System.out.println("【发送了用户："+ user.getName() +"】");
        jmsTemplate.convertAndSend(dest, user);
    }

    @Override
    @JmsListener(destination = dest)
    public void receiveMsg(User user) {
        System.out.println("【接收了用户："+ user.getName() +"】");
    }
}
