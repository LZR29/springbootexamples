package com.lzr.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.lzr.redis")
public class RedisApplication {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    //redis连接工厂
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    //redis消息监听器
    private MessageListener messageListener;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler;
    /**
     * 定义自定义后的初始化方法
     */
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    /**
     * 设置Redistemplate的序列化器
     * 对于键和其散列数据类型的field都修改成stringSerializer序列化器
     */
    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

    /**
     * 创建任务池
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if(taskScheduler != null){
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisontainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //redis连接池
        container.setConnectionFactory(redisConnectionFactory);
        //设置运行池
        container.setTaskExecutor(initTaskScheduler());
        //定义监听渠道，名称为topic1
        Topic topic = new ChannelTopic("topic1");
        //监听器监听redis消息
        container.addMessageListener(messageListener,topic);
        return container;
    }


    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
