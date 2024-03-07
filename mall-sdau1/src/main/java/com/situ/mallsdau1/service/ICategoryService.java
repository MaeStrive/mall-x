package com.situ.mallsdau1.service;

import com.situ.mallsdau1.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdau1.vo.TableVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-03
 */
public interface ICategoryService extends IService<Category> {

    TableVO selectList(Integer page, Integer limit);
}
