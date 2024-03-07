package com.situ.mallsdauweb.mapper;

import com.situ.mallsdauweb.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface ProductMapper extends BaseMapper<Product> {
@Select("select * from product where category_id=#{id} order by price limit 0,1")
    Product selectByCategory(Integer id);
}
