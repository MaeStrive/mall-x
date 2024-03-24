package com.situ.mallsdauweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @作者：大叔azhe
 * @api：详细描述
 * @创建时间：11:27 2023/6/12
 */
@Configuration
public class VirtualConf implements WebMvcConfigurer {


    @Value("${imgPath}")
    private String imgPath;
    @Override //上传图片后，图片的地址映射
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:"+imgPath);
    }
}
