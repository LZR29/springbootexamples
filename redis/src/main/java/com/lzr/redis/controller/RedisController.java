package com.lzr.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
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

    /**
     * 事务
     * 对于注释的代码#####，因为我们存的是一个字符串所以对它进行加1是会出错的，这时redis的事务有个特点需要我们注意。
     * 在redis中，事务队列的命令出错的话只是报出错误，不会影响后面的命令执行，所以在执行redis事务前要严格检查数据。
     * @return
     */
    @RequestMapping("/multi")
    public Map<String, Object> testMulti(){
        redisTemplate.opsForValue().set("key1","value1");
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //监控key1
                redisOperations.watch("key1");
                //开启事务，在exec执行之前，全部命令只是进入队列
                redisOperations.multi();
                redisTemplate.opsForValue().set("key2","value2");
                //redisTemplate.opsForValue().increment("key1",1); //######
                Object value2 = redisTemplate.opsForValue().get("key2");
                System.out.println("命令在队列，所以value2的值为null【" + value2 + "】");
                redisTemplate.opsForValue().set("key3","value3");
                Object value3 = redisTemplate.opsForValue().get("key3");
                System.out.println("命令在队列，所以value3的值为null【" + value3 + "】");
                //执行exec命令，将先判断监控的key1是否被修改，如果是，不执行事务，否则执行事务
                return redisOperations.exec();
            }
        });
        System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
