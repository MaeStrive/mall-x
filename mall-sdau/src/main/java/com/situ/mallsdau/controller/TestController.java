package com.situ.mallsdau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public String t1(){
        System.out.println("执行了t11111方法");

        return "index";
    }

    @RequestMapping("/t2")
    public void t2(){
        System.out.println("执行了t222222方法");
    }


}
