package com.situ.mallsdau;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.situ.mallsdau.mapper")
@SpringBootApplication
public class MallSdauApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSdauApplication.class, args);
    }

}
