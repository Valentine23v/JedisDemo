package com.safari;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String [] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);//最大连接数
        config.setMaxIdle(10);//最大空闲连接数

        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            //jedis.auth("xxx");//如果有密码
            jedis.set("name","测试Pool");
            String name=jedis.get("name");
            System.out.println(name);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){
                jedis.close();
            }
            if (jedisPool!=null){
                jedisPool.close();
            }
        }

    }
}
