package com.situ.mallsdau1.controller;

import com.situ.mallsdau1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    //请求返回登陆页面
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //请求验证用户密码是否正确
    @PostMapping("/login")
    public String check(String username, String password, HttpSession session){
        boolean b=userService.check(username,password,session);
        if(b){
            //请求转发：请求发送一次
            //重定向：请求发两次
            return "redirect:/index";
    }else{
            return "login";
        }
    }
}
