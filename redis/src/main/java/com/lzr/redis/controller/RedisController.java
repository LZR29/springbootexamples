package com.lzr.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @authoor linzerong
 * @create 2019-05-20 10:20
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringAndHash")
    public Map<String, Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1","value1");
        //这里使用的是jdk的序列化器，所以保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int");
        //获取jedis连接
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //减1操作，因为RedisTemplate是不支持的，所以先获取底层连接再操作
        jedis.decr("int");
        Map<String,String> map = new HashMap<>();
        map.put("field1","value1");
        map.put("field2","value2");
        //存入散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash",map);
        //新增字段
        stringRedisTemplate.opsForHash().put("hash","field3","value3");
        //绑定操作的key，连续操作它
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
        //删除字段
        hashOperations.delete("field1","field2");
        //新增字段
        hashOperations.put("field4","value4");
        Map<String,Object> result = new HashMap<>();
        result.put("success",true);
        return result;
    }

}
