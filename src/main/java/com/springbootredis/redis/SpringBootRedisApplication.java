package com.springbootredis.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.springbootredis.redis.dao"})
@ServletComponentScan({"com.springbootredis.redis"})//扫描servlet的注解
//@EnableCaching //开启缓存
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5)//开启redis的 session共享
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}
