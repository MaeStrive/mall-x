package com.situ.mallsdau1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.entity.Member;
import com.situ.mallsdau1.exception.BusinessException;
import com.situ.mallsdau1.service.ICategoryService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/dellist")
    @ResponseBody
    public void dellist(@RequestBody LinkedList<Member> data){
        System.out.println(data);

        data.forEach((item)->{
            //先查一下要删除的有没有子分类
            QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", item.getId());
            List<Category> list = categoryService.list(queryWrapper);
            if (list.size() > 0) {
                throw new BusinessException("有子分类");
            }
            categoryService.removeById(item.getId());
        });

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

    @GetMapping("/count")
    @ResponseBody
    public Long userCount(){

        Long users = categoryService.count();
        return users;
    }
}
