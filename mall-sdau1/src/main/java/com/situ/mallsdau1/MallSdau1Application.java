package com.situ.mallsdau1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages="com.situ.mallsdau1.mapper")
public class MallSdau1Application {

    public static void main(String[] args) {

        SpringApplication.run(MallSdau1Application.class, args);
    }

}
