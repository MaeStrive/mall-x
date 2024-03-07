package com.situ.mallsdau1.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.entity.Product;
import com.situ.mallsdau1.mapper.ProductMapper;
import com.situ.mallsdau1.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public TableVO selectList(Integer limit, Integer page,String keyword) {
        TableVO vo=new TableVO();
        PageHelper.startPage(page,limit);
        List<ProductVO> list=productMapper.selectProduct(keyword);
        vo.setData(list);
        vo.setCount(new PageInfo<>(list).getTotal());
        vo.setCode(0);
        return vo;
    }

}
