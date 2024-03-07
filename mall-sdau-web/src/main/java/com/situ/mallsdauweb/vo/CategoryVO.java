package com.situ.mallsdauweb.vo;

import lombok.Data;

import java.util.List;

//描述一个一级分类
@Data
public class CategoryVO {
    private String name;
    private List<SubCategoryVO> children;

}
