package com.situ.mallsdau1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdau1.entity.OrderInfo;
import com.situ.mallsdau1.vo.TableVO;


/**
 *
 */
public interface OrderInfoService extends IService<OrderInfo> {

    TableVO select(Integer limit, Integer page, String k);
}
