package com.situ.mallsdauweb.service.impl;

import com.situ.mallsdauweb.entity.Category;
import com.situ.mallsdauweb.mapper.CategoryMapper;
import com.situ.mallsdauweb.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.vo.CategoryVO;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
@Override
    public List<CategoryVO> categories(){
    List<CategoryVO> list=baseMapper.categories();
    return list;

}
}
