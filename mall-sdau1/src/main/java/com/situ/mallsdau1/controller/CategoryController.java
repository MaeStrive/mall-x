package com.situ.mallsdau1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.exception.BusinessException;
import com.situ.mallsdau1.service.ICategoryService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/page")
    public String index() {
        return "category";
    }

    @RequestMapping("/list")
    @ResponseBody
    public TableVO list(Integer page, Integer limit) {
        return categoryService.selectList(page, limit);
    }

    @PostMapping("/del")
    @ResponseBody
    public void del(Integer id) {
        //先查一下要删除的有没有子分类
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        List<Category> list = categoryService.list(queryWrapper);
        if (list.size() > 0) {
            throw new BusinessException("有子分类");
        }
        categoryService.removeById(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(Category category) {
        categoryService.saveOrUpdate(category);
    }

    @GetMapping("/info")
    @ResponseBody
    public Category selectById(Integer id) {
        return categoryService.getById(id);
    }

    @GetMapping("/top")
    @ResponseBody
    public List<Category> tops() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        return categoryService.list(queryWrapper);
    }

    @GetMapping("/subs")
    @ResponseBody
    public List<Category> subs(Integer parentId) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        return categoryService.list(queryWrapper);
    }
}
