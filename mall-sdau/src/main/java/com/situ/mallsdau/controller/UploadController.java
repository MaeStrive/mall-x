package com.situ.mallsdau.controller;

import lombok.SneakyThrows;
import net.sf.jsqlparser.schema.MultiPartName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.situ.mallsdau.vo.ResultVO;

import java.io.File;

/**
 * @Author: Mae
 * @Date: 2023/6/3
 * @Time: 20:22
 * @Description:
 */
@Controller
@RequestMapping("/")
public class UploadController {
    @PostMapping("/upload")
    @ResponseBody
    public ResultVO upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = System.currentTimeMillis() + suffix;
        File f = new File("D:/mall-sdau/img/" + newFilename);
        try {
            file.transferTo(f);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setData("/up/" + newFilename);
        resultVO.setCode(0);
        return resultVO;
    }
}