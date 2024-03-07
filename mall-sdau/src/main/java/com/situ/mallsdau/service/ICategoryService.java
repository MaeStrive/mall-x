package com.situ.mallsdau.service;

import com.situ.mallsdau.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdau.vo.TableVO;


public interface ICategoryService extends IService<Category> {

    TableVO selectList(Integer page, Integer limit);
}
