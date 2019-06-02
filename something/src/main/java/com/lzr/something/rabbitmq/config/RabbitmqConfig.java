package com.lzr.something.rabbitmq.config;



import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linzerong
 * @create 2019-06-02 21:36
 */
@Configuration
public class RabbitmqConfig {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @Bean
    public Queue createQueueMsg(){
        return new Queue(msgQueueName ,true);
    }

    @Bean
    public Queue createQueueUser(){
        return new Queue(userQueueName, true);
    }
}
