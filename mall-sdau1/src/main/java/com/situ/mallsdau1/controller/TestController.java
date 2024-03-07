package com.situ.mallsdau1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {
    @RequestMapping("/t1")
    public String t1(){
       System.out.println("t1");
       return "index";
    }
    @RequestMapping("/t2")
    public void t2(){
        System.out.println("t2");
    }
}
