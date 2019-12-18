package com.yxd.auth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Auth2ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void test(){
        // 异步操作
        CompletableFuture.runAsync(()->{
            redisTemplate.opsForValue().set("key", "value");
        });

    }


}
