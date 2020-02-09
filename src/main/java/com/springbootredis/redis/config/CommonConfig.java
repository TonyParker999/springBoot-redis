package com.springbootredis.redis.config;


import com.springbootredis.redis.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableCaching
@PropertySource({"classpath:redis.properties","classpath:config/myTest.properties"})
public class CommonConfig {
    @Value("${im.hs.server.redis.sentinel1.host}")
    private String host;

    @Value("${userTest.name}")
    private String name;


    @Bean(name = "user")
    public Object User(){
        System.out.println(host);
        User user = new User();
        return user;
    }

}
