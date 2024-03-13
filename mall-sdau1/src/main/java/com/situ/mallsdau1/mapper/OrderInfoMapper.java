package com.situ.mallsdau1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.situ.mallsdau1.entity.OrderInfo;
import com.situ.mallsdau1.vo.OrderInfoVO;
import com.situ.mallsdau1.vo.ProductVO;

import java.util.List;


/**
 * @Entity generator.domain.OrderInfo
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderInfoVO> selectProduct(String keyword);
}




