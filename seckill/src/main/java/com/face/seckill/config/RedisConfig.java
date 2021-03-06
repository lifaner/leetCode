package com.face.seckill.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * Create by lifan.
 * Date: 2019/5/5.
 * Time: 10:25.
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate<?, ?> redisTemplateInit() {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<>(Object.class));
        initRedisData();
        return redisTemplate;
    }

    private void initRedisData() {
        log.info("\n----------------------------------------------------------\n\t" +
                " redis data init"+
                "\n----------------------------------------------------------");
        redisTemplate.opsForValue().set("COM:FACE:SECKILLNUM",10);
        log.info("SECKILLNUM is {}", redisTemplate.opsForValue().get("COM:FACE:SECKILLNUM"));
    }
}
