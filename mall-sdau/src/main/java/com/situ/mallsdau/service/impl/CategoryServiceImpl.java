package com.situ.mallsdau.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau.entity.Category;
import com.situ.mallsdau.mapper.CategoryMapper;
import com.situ.mallsdau.service.ICategoryService;
import com.situ.mallsdau.vo.TableVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kkkkkk
 * @since 2023-06-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public TableVO selectList(Integer page, Integer limit) {
        TableVO vo = new TableVO();
        PageHelper.startPage(page,limit);
        List<Category> list = baseMapper.selectList(null);
        vo.setData(list);
        vo.setCount(new PageInfo<>(list).getTotal());
        vo.setCode(0);
        return vo;
    }
}
