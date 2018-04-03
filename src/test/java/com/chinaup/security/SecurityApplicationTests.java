package com.chinaup.security;

import com.chinaup.security.common.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    private RedisCache redisCache;
    @Test
    public void contextLoads() {
        redisCache.setString("value","慧敏");
    }

}
