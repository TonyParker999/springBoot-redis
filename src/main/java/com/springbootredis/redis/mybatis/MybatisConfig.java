package com.springbootredis.redis.mybatis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;
    @Bean()
    public MapperHotDeployPlugin mapperHotDeployPlugin(){
        MapperHotDeployPlugin mapperHotDeployPlugin = new MapperHotDeployPlugin();
        mapperHotDeployPlugin.setMapperLocation(mapperLocation);
        return mapperHotDeployPlugin;
    }
}