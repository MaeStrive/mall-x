package com.situ.mallsdauweb.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Mae
 * @Date: 2024/3/13
 * @Time: 21:47
 * @Description:
 */
@Data
public class CartTotalVO {
    private Integer total;
    private BigDecimal price;
}
