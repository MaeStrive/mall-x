package com.situ.mallsdau.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdau.entity.Category;
import com.situ.mallsdau.service.ICategoryService;
import com.situ.mallsdau.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kkkkkk
 * @since 2023-06-03
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //要产品分类管理的页面
    @GetMapping("/page")
    public String page() {
        return "category";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableVO list(Integer page, Integer limit) {
        return categoryService.selectList(page, limit);
    }

    @PostMapping("/del")
    @ResponseBody
    public void del(Integer id) {
        categoryService.removeById(id);
    }

    @GetMapping("/info")
    @ResponseBody
    public Category selectById(Integer id) {
        return categoryService.getById(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(Category category){
        categoryService.saveOrUpdate(category);
    }

    @GetMapping("/top")
    @ResponseBody
    public List<Category> tops(){

        //创建一个查询条件
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",0);
        return categoryService.list(queryWrapper);
    }

}
