package com.safari;

import redis.clients.jedis.Jedis;

public class JedisTest {

    public static void main(String [] args) {
        //新建一个Jedis连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);//用的本地的Redis,端口6379
        //jedis.auth("xxx");//如果有密码
        System.out.println(jedis.ping());//测试是否能成功连接

        jedis.set("name","测试名");
        String name=jedis.get("name");
        System.out.println(name);
        jedis.close();//关闭连接



    }

}
