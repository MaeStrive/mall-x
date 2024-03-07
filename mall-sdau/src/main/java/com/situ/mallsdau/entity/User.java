package com.situ.mallsdau.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String sex;

    private String name;

    private Integer status;

    private LocalDateTime createTime;
}
