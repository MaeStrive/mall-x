package com.situ.mallsdau1.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    private Integer age;
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private String name;
    private String sex;
    private LocalDateTime createTime;
}
