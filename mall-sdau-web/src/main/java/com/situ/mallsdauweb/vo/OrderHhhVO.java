package com.situ.mallsdauweb.vo;

import com.situ.mallsdauweb.entity.MemberAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Mae
 * @Date: 2024/3/26
 * @Time: 20:13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHhhVO {
    Integer id;
    MemberAddress memberAddress;
    BigDecimal price;
}
