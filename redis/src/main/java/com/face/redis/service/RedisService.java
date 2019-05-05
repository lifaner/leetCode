package com.face.redis.service;

import com.face.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Create by lifan.
 * Date: 2019/5/5.
 * Time: 10:17.
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    private static final String KEY = "COM:FACE:REDIS";

    @PostConstruct
    private void doAdd(){
        User u = new User();
        u.setName("李范");
        u.setAge("30");

        redisTemplate.opsForValue().set(KEY, u, 30, TimeUnit.SECONDS);
        Boolean aBoolean = redisTemplate.hasKey(KEY);
        User user = redisTemplate.opsForValue().get(KEY);
        System.out.println(aBoolean);
        log.info("userName="+user.getName());
        log.info("userAge="+user.getAge());
    }
}
