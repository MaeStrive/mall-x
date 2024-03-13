package com.situ.mallsdau1.controller;

import com.situ.mallsdau1.entity.User;
import com.situ.mallsdau1.mapper.UserMapper;
import com.situ.mallsdau1.service.UserService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/page")
    public String user(){
        return "user";
    }
    @RequestMapping("/list")
    @ResponseBody
    public TableVO list(@RequestParam Integer limit,@RequestParam Integer page,@RequestParam(value="keyword",required=false) String k){
        return userService.select(limit, page,k);
    }
   // @RequestMapping(value="/del",method= RequestMethod.POST)
    @PostMapping("/del")
    @ResponseBody
    public void del(Integer userId){
    userService.delete(userId);

    }

    @PostMapping("/dellist")
    @ResponseBody
    public void dellist(@RequestBody LinkedList<User> data){
        System.out.println(data);
        userMapper.deleteBatchIds(data.stream().map((item)->item.getId()).collect(Collectors.toList()));

    }

    @PostMapping("/save")
    @ResponseBody
    public void save(User user){
        userService.save(user);

    }
    @GetMapping("/info")
    @ResponseBody
    public User selectById(Integer id){
        return userService.selectById(id);
    }

    @GetMapping("/count")
    @ResponseBody
    public Long userCount(){

        Long users = userMapper.selectCount(null);
        return users;
    }
}
