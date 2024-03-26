package com.situ.mallsdauweb.service;


import com.situ.mallsdauweb.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdauweb.vo.OrderHhhVO;
import com.situ.mallsdauweb.vo.OrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
public interface IOrderInfoService extends IService<OrderInfo> {
    OrderHhhVO saveOrder(Integer addId, String cartIds);
      void    updateStatus (String code,String status);

    List<OrderVO> selectByStatus(String status);
}
