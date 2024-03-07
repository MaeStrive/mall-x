package com.situ.mallsdauweb.mapper;

import com.situ.mallsdauweb.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> searchAllByOrderId(Integer orderId);

}
