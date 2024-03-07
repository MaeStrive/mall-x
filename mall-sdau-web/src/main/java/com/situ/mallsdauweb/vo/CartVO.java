package com.situ.mallsdauweb.vo;

import lombok.Data;

import java.math.BigDecimal;

//购物车数据
@Data
public class CartVO {
    private Integer id;
    private String imgPath;
    private String productName;
    private BigDecimal price;
    private Integer amount;


}
