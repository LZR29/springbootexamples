package com.lzr.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.lzr.redis")
public class RedisApplication {

    @Autowired
    private RedisTemplate redisTemplate = null;

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


    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
