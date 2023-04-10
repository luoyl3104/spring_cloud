package com.luoyl.eureka_redis.utils;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.138.145",6379);
        jedis.auth("123456");

        //jedis.set("name","abcd");
        //String name = jedis.get("name");
        //System.out.println(name);

        //jedis.flushDB();

        //System.out.println(jedis.exists("name"));
        //jedis.del("");

        jedis.sadd("a","1");
        jedis.sadd("a","2");
        jedis.sadd("a","3");

        jedis.sadd("b","2");
        jedis.sadd("b","3");
        jedis.sadd("b","4");

        Set<String> sinter = jedis.sinter("a", "b");
        for (String s : sinter) {
            System.out.println(s);
        }



        jedis.close();



    }

}
