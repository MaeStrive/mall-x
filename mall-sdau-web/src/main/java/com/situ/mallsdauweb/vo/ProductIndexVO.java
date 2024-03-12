package com.situ.mallsdauweb.vo;

import com.situ.mallsdauweb.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2024/3/12
 * @Time: 21:39
 * @Description:
 */
@Data
public class ProductIndexVO {
    private Integer categoryId;
    private String categoryName;
    private String iconPath;
    private List<Product> product;
}
