package com.example.cachespringjedisredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheSpringJedisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSpringJedisRedisApplication.class, args);
    }
}
