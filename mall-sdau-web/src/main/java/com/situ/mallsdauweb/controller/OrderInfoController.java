package com.situ.mallsdauweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdauweb.entity.OrderInfo;
import com.situ.mallsdauweb.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService orderInfoService;

    @GetMapping("/getInfo")
    public List<OrderInfo> getOrderInfo() {
        QueryWrapper<OrderInfo> queryWrap = new QueryWrapper<>();
        queryWrap.eq("status", "待支付").or().eq("status", "已支付");
        List<OrderInfo> list = orderInfoService.list(queryWrap);
        return list;
    }

}
