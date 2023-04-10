package com.luoyl.eureka_redis;

import com.luoyl.eureka_redis.entity.User;
import com.luoyl.eureka_redis.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaRedisApplicationTests {

    @Autowired
    private RedisUtils redisUtils;


    @Test
    void contextLoads() {
        User user = new User("xiaoming", 18, true);
        redisUtils.set("xiaoming",user);
    }

    @Test
    void get(){
        Object user = redisUtils.getKey("xiaoming");
        System.out.println(user);
    }

}
