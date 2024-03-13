package com.situ.mallsdau1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.OrderInfo;
import com.situ.mallsdau1.mapper.OrderInfoMapper;
import com.situ.mallsdau1.mapper.ProductMapper;
import com.situ.mallsdau1.service.OrderInfoService;
import com.situ.mallsdau1.vo.OrderInfoVO;
import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Override
    public TableVO select(Integer limit, Integer page, String k) {
        TableVO vo=new TableVO();
        PageHelper.startPage(page,limit);
        List<OrderInfoVO> list=orderInfoMapper.selectProduct(k);
        vo.setData(list);
        vo.setCount(new PageInfo<>(list).getTotal());
        vo.setCode(0);
        return vo;
    }
}




