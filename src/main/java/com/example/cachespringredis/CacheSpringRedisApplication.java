package com.example.cachespringredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheSpringRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSpringRedisApplication.class, args);
    }
}
