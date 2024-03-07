package com.situ.mallsdauweb.service;

import com.situ.mallsdauweb.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdauweb.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface ICategoryService extends IService<Category> {

    List<CategoryVO> categories();
}
