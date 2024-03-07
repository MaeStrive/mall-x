package com.situ.mallsdau.controller;

import com.situ.mallsdau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //请求用户名密码是否正确
    @PostMapping("/login")
    public String check(String username, String password, HttpSession session) {
        boolean b = userService.check(username, password,session);
        if (b) {
            //请求转发
            //重定向
            return "redirect:/index";
        } else {
            return "login";
        }
    }
}
