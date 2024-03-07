package com.situ.mallsdau1.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface ProductMapper extends BaseMapper<Product> {
    List<ProductVO> selectProduct(String keyword);

}
