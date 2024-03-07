package com.situ.mallsdauweb.service.impl;

import com.situ.mallsdauweb.entity.Category;
import com.situ.mallsdauweb.entity.Product;
import com.situ.mallsdauweb.mapper.CategoryMapper;
import com.situ.mallsdauweb.mapper.ProductMapper;
import com.situ.mallsdauweb.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private CategoryMapper categoryMapper;

    @Override
    public List<Product> phones() {
        List<Product> result =new ArrayList<>();
        //先查一下最新的八个系列
        List<Category> categories=categoryMapper.latest(1);
        for(Category c:categories){
            Product p =baseMapper.selectByCategory(c.getId());
            if(p!=null){
            result.add(p);}
        }
        return result;
    }
}
