package com.situ.mallsdauweb.service.impl;

import com.situ.mallsdauweb.entity.Category;
import com.situ.mallsdauweb.entity.Product;
import com.situ.mallsdauweb.mapper.CategoryMapper;
import com.situ.mallsdauweb.mapper.ProductMapper;
import com.situ.mallsdauweb.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.vo.ProductIndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductIndexVO> phones() {
        List<ProductIndexVO> result = new LinkedList<>();
        //先查一下最新的6个系列
        List<Category> categories = categoryMapper.latest(0);
        for (Category category : categories) {
            LambdaQueryWrapper<Category> queryWrap = new LambdaQueryWrapper<>();
            queryWrap.eq(Category::getParentId, category.getId()).orderByAsc(Category::getSequence).last("limit 1");
            Category category0 = categoryMapper.selectOne(queryWrap);
            LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Product::getCategoryId, category0.getId());
            ProductIndexVO productIndexVO = new ProductIndexVO();
            List<Product> products = productMapper.selectList(queryWrapper);
            productIndexVO.setProduct(products);
            productIndexVO.setCategoryId(category0.getId());
            productIndexVO.setCategoryName(category0.getName());
            productIndexVO.setIconPath(category0.getIconPath());
            result.add(productIndexVO);
        }
        return result;
    }

    @Override
    public List<Product> listProductByCategoryId(Integer categoryId) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getCategoryId, categoryId);
        return productMapper.selectList(queryWrapper);
    }
}
