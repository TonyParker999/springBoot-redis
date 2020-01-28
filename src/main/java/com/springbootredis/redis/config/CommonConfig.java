package com.springbootredis.redis.config;


import com.springbootredis.redis.model.User;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class CommonConfig {
    @Bean(name = "user")
    public Object User(){
        return new User();
    }

}
