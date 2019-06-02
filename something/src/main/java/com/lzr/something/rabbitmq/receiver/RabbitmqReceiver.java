package com.lzr.something.rabbitmq.receiver;

import com.lzr.something.rabbitmq.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author linzerong
 * @create 2019-06-02 22:18
 */
@Component
public class RabbitmqReceiver {

    @RabbitListener(queues = "${rabbitmq.queue.msg}")
    public void receiverMsg(String msg){
        System.out.println("【收到消息：" + msg +"】");
    }

    @RabbitListener(queues = "${rabbitmq.queue.user}")
    public void receiverMsg(User user){
        System.out.println("【收到用户：" + user.getName() +"】");
    }
}
