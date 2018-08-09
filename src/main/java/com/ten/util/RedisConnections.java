package com.ten.util;

import redis.clients.jedis.Jedis;

/**
 * jedis-API 测试Redis连接
 *
 * @date 2018/7/4
 * @auther ten
 */
public class RedisConnections {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        int i = 0;

        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.flushDB();
            jedis.close();
        }

        System.out.println("redis operating " + i + " per second");
    }
}
