package com.situ.mallsdau1.service;

import com.situ.mallsdau1.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdau1.vo.TableVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface IProductService extends IService<Product> {
    TableVO selectList(Integer limit, Integer page,String keyword);
}
