package com.situ.mallsdauweb.vo;

import com.situ.mallsdauweb.entity.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2023/6/9
 * @Time: 20:26
 * @Description:
 */
@Data
public class OrderVO {
    private LocalDateTime createTime;

    private String username;

    private String code;

    private List<Product> product;

    private BigDecimal price;

    private String status;
}
