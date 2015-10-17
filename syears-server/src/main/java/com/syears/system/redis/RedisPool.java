package com.syears.system.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by yousheng on 15/8/14.
 */
@Component
public class RedisPool {


    @Bean
    public Jedis getJedis() {

        Jedis jedis = new Jedis("127.0.0.1");
        jedis.auth("12345678");

        return jedis;
    }
}
