package com.situ.mallsdauweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.situ.mallsdauweb.mapper")
public class MallSdauWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSdauWebApplication.class, args);
    }

}
