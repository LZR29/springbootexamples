package com.lzr.something.rabbitmq.service.impl;

import com.lzr.something.rabbitmq.bean.User;
import com.lzr.something.rabbitmq.service.RabbitmqService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author linzerong
 * @create 2019-06-02 22:05
 */
@Service
public class RabbitmqServiceImpl implements RabbitTemplate.ConfirmCallback, RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting;

    @Value("${rabbitmq.queue.user}")
    private String userRouting;

    @Override
    public void sendMsg(String msg) {
        System.out.println("【发送消息：" + msg + "】");
        //回调
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(msgRouting,msg);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("【发送消息：" + user + "】");
        //回调
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(userRouting,user);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            System.out.println("消息成功消费！");
        }else {
            System.out.println("消息消费失败：" + cause);
        }
    }
}
