package com.situ.mallsdau1.controller;


import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.situ.mallsdau1.service.IProductService;
import com.situ.mallsdau1.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService prodcutService;

    @RequestMapping("/page")
    public String product() {
        return "product";
    }

    @ResponseBody
    @PostMapping("/save")
    public void save(Product product) {
        prodcutService.save(product);
    }

    @ResponseBody
    @GetMapping("/list")
    public TableVO list(@RequestParam Integer limit, @RequestParam Integer page, @RequestParam(value = "keyword", required = false) String k) {
        return prodcutService.selectList(limit, page, k);
    }
}
