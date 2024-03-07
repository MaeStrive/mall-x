package com.situ.mallsdauweb.controller;


import com.situ.mallsdauweb.entity.Product;
import com.situ.mallsdauweb.service.ICategoryService;
import com.situ.mallsdauweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/telephone")
    @ResponseBody
    public List<Product> phones(){
        return productService.phones();
    }
}
