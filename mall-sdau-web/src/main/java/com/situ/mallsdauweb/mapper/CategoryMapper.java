package com.situ.mallsdauweb.mapper;

import com.situ.mallsdauweb.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.situ.mallsdauweb.vo.CategoryVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVO> categories();

    @Select("select * from category where parent_id=#{parentId} order by  sequence limit 0,8 ")
    List<Category> latest(int parentId);

}
