package com.situ.mallsdauweb.mapper;

import com.situ.mallsdauweb.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
@Update("update order_info set status=#{status} where code=#{code}" )
void updateStatus(@Param("code") String code,@Param("status") String status);

    @Select("select * from order_info where status like '%${status}%'")
    List<OrderInfo> selectAllByStatus(String status);
}
