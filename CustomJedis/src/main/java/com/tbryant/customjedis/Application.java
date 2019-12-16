package com.tbryant.customjedis;

public class Application {
    public static void main(String[] args) {
        CustomRedisClient redisClient = new CustomRedisClient("127.0.0.1", 6379);
        System.out.println(redisClient.set("tonny", "bryant"));
        System.out.println(redisClient.get("tonny"));
        System.out.println(redisClient.incr("count"));
    }
}
