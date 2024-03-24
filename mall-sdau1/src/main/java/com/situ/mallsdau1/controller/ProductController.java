package com.situ.mallsdau1.controller;


import com.situ.mallsdau1.mapper.ProductMapper;
import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.situ.mallsdau1.service.IProductService;
import com.situ.mallsdau1.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductMapper productMapper;
    @Value("${imgPath}")
    private String imgPath;

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
    @PostMapping("/update")
    public void update(Product product) {
        prodcutService.updateById(product);
    }

    @ResponseBody
    @GetMapping("/list")
    public TableVO list(@RequestParam Integer limit, @RequestParam Integer page, @RequestParam(value = "keyword", required = false) String k) {
        TableVO tableVO = prodcutService.selectList(limit, page, k);
        System.out.println("嘎嘎嘎");
        System.out.println(tableVO);
        return tableVO;
    }

    @PostMapping("/dellist")
    @ResponseBody
    public void dellist(@RequestBody LinkedList<Product> data){
        System.out.println(data);
        productMapper.deleteBatchIds(data.stream().map((item)->item.getId()).collect(Collectors.toList()));

    }

    @PostMapping("/del")
    @ResponseBody
    public void del(Integer userId){
        productMapper.deleteById(userId);
    }

    @GetMapping("/info")
    @ResponseBody
    public Product selectById(Integer id) {
        return prodcutService.getById(id);
    }

    @PostMapping("/upload")
    @ResponseBody
    public TableVO handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
        TableVO tableVO = new TableVO();
        if (file.isEmpty()) {
            tableVO.setMsg("请先选择文件");
            return tableVO;
        }
        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            File dest = new File(imgPath + fileName);
            file.transferTo(dest);
            tableVO.setCode(200);
            tableVO.setMsg("上传成功");
            LinkedList<String> objects = new LinkedList<>();
            objects.add(fileName);
            tableVO.setData(objects);
            return tableVO;
        } catch (IOException e) {
            e.printStackTrace();
            tableVO.setMsg("上传失败");
            return tableVO;
        }
    }
}
