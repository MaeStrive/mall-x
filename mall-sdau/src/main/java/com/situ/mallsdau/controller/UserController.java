package com.situ.mallsdau.controller;

import com.situ.mallsdau.entity.User;
import com.situ.mallsdau.service.UserService;
import com.situ.mallsdau.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/page")
    public String index() {
        return "user";
    }

    @RequestMapping("/list")
    @ResponseBody
    public TableVO list(@RequestParam Integer limit, @RequestParam Integer page, String keyword) {
        return userService.select(limit, page, keyword);
    }

    //@RequestMapping(value="/del",method = RequestMethod.POST)
    @PostMapping("/del")
    @ResponseBody
    public void del(Integer userId) {
        userService.delete(userId);
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(User user) {
        userService.save(user);
    }

    @GetMapping("/info")
    @ResponseBody
    public User selectById(Integer id) {
        return userService.selectById(id);
    }

}
