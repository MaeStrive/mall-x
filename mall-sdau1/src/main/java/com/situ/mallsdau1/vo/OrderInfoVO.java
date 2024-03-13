package com.situ.mallsdau1.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfoVO {
    private Integer id;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Integer memberId;

    /**
     *
     */
    private BigDecimal price;

    /**
     *
     */
    private Integer addid;

    /**
     *
     */
    private String status;
}
