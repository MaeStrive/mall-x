package com.situ.mallsdau1.controller;

import com.situ.mallsdau1.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class UploadController {

    @Value("${imgPath}")
    private String imgPath;
    @PostMapping("/upload")
    @ResponseBody
    public ResultVO upload(MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFilename = System.currentTimeMillis() + suffix;
        File f = new File(imgPath + newFilename);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ResultVO vo = new ResultVO();
        vo.setMsg("");
        vo.setCode(0);
        vo.setData("/file/" + newFilename);
        return vo;
    }
}
