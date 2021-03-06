package com.asser.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {

    @Test
    public void testJedis(){
        //创建一个Jedis的连接
        Jedis jedis = new Jedis("114.215.146.45", 6379);
        //执行redis命令
        jedis.set("key1", "hello world");
        //从redis中取值
        String result = jedis.get("key1");
        //打印结果
        System.out.println(result);
        //关闭连接
        jedis.close();

    }

    @Test
    public void testJedisPool() {
        //创建一连接池对象
        JedisPool jedisPool = new JedisPool("114.215.146.45", 6379);
        //从连接池中获得连接
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("key1") ;
        System.out.println(result);
        //关闭连接
        jedis.close();

        //关闭连接池
        jedisPool.close();
    }

}
