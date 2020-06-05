package com.bookman.springtrains.bookcommon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RedisLimit {

    @Autowired
    DefaultRedisScript<Boolean> redisScript;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Value("${redis.limit:2}")
    private int limit;

    /**
     * true     has limit
     * false    not limit
     *
     * @return
     */
    public boolean checkIsLimit(){
        String key = String.valueOf(System.currentTimeMillis() / 1000L);

        Boolean result = redisTemplate.execute(redisScript, Collections.singletonList(key), String.valueOf(limit));
        if (result == null){
            return true;
        }
        return result;
    }
}
