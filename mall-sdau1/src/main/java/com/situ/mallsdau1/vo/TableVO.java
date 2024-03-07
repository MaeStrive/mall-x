package com.situ.mallsdau1.vo;

import lombok.Data;

import java.util.List;

@Data
public class TableVO {
    private Integer code;
    private String msg;
    private Long count;
    private List<?> data;

}
