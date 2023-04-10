package com.luoyl.eureka_redis.service;

import com.luoyl.eureka_redis.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    /**
     * 缓存注解的使用：
     * Cacheable：调用方法时先从缓存中查询有没有对应key的数据，如果有直接从缓存获取返回，如果没有则执行方法，将返回值存入缓存中。
     * CacheEvict：调用方法后从缓存中删除对应key的数据
     * Caching：当一个方法需要查询多个缓存或者删除多个缓存时使用
     *
     */

    //unless 参数就是不执行Cacheable的条件
    @Cacheable(value = "cache1",key = "xiaoming",unless = "xiaoming == null ")
    public User getByKey(String key){
        return null;
    }
}
