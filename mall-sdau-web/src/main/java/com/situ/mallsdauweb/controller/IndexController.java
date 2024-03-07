package com.situ.mallsdauweb.controller;

import com.situ.mallsdauweb.service.ICategoryService;
import com.situ.mallsdauweb.service.IProductService;
import com.situ.mallsdauweb.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
@GetMapping({"/index","/"})
    public String index(Model model){
    //带上（产品分类）数据
    List<CategoryVO> list=categoryService.categories();
    model.addAttribute("categories",list);
    return "index";
}
@GetMapping("/detail")
    public String detail(Integer id,Model model){
//带上当前这款商品的数据
    model.addAttribute("product",productService.getById(id));
    return "HomeAppliance";
}
}
