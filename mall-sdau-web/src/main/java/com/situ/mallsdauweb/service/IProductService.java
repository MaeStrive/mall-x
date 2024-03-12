package com.situ.mallsdauweb.service;

import com.situ.mallsdauweb.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdauweb.vo.ProductIndexVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface IProductService extends IService<Product> {

    List<ProductIndexVO> phones();
}
