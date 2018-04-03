package com.chinaup.security.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.io.Serializable;

@Component
public class RedisCache {

    @Autowired
    private RedisTemplate<?,?> redisTemplate;

    public void setString(String key,String value){
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(key.getBytes(),value.getBytes());
                return true;
            }
        });
    }
}
