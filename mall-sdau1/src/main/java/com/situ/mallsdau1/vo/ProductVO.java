package com.situ.mallsdau1.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVO {
    private Integer Id;

    private String name;

    private BigDecimal price;

    private String edition;

    private String color;

    private String categoryName;

    private Integer status;

    private String imgPath;
}
