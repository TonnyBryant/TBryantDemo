package com.tbryant.customjedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 8888);
        System.out.println(jedis.set("tonny", "bryant"));
        System.out.println(jedis.get("tonny"));
        System.out.println(jedis.incr("count"));
    }
}
