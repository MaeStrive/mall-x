package com.situ.mallsdau.vo;

import lombok.Data;

import java.util.List;

@Data
//用这个类描述　返回给前台的数据格式
public class TableVO {

    private Integer code;

    private String msg;

    private Long count;

    private List<?> data;

}
