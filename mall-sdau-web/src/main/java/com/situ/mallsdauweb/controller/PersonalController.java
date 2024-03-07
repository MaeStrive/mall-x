package com.situ.mallsdauweb.controller;

import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/address")
    public String adress() {
        return "address";
    }

    @GetMapping("/page")
    public String profile(Model model) {
        Member current = RequestUtil.getCurrent();
        model.addAttribute("user", current);
        return "personal";
    }
}