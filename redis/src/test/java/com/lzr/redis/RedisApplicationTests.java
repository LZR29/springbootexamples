package com.lzr.redis;

import com.lzr.redis.dao.RedisDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedis() {

        redisDao.setKey("name", "lzr");
        redisDao.setKey("age", "22");
        Assert.assertEquals("lzr", redisDao.getValue("name"));
        Assert.assertEquals("22", redisDao.getValue("age"));
    }
}
