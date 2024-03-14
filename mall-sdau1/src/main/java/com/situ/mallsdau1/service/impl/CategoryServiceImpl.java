package com.situ.mallsdau1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.entity.OrderInfo;
import com.situ.mallsdau1.mapper.CategoryMapper;
import com.situ.mallsdau1.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdau1.vo.TableVO;
import net.sf.jsqlparser.schema.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public TableVO selectList(Integer page, Integer limit,String k) {
        TableVO vo=new TableVO();
        PageHelper.startPage(page,limit);
        LambdaQueryWrapper<Category> orderInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(k)) {
            orderInfoLambdaQueryWrapper.like(Category::getName,k);
        }
        List<Category>list=baseMapper.selectList(orderInfoLambdaQueryWrapper);
        vo.setData(list);
        vo.setCount(new PageInfo<>(list).getTotal());
        vo.setCode(0);
        return vo;
    }
}
