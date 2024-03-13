package com.situ.mallsdau1.controller;

import com.situ.mallsdau1.entity.Member;
import com.situ.mallsdau1.entity.User;
import com.situ.mallsdau1.mapper.MemberMapper;
import com.situ.mallsdau1.service.IMemberService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Mae
 * @Date: 2023/6/10
 * @Time: 8:18
 * @Description:
 */
@RequestMapping("/member")
@Controller
public class MemberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MemberMapper memberMapper;

    @PostMapping("/dellist")
    @ResponseBody
    public void dellist(@RequestBody LinkedList<Member> data){
        System.out.println(data);
        memberMapper.deleteBatchIds(data.stream().map((item)->item.getId()).collect(Collectors.toList()));

    }

    @GetMapping("/page")
    public String page() {
        return "member";
    }

    @RequestMapping("/list")
    @ResponseBody
    public TableVO list(Integer page, Integer limit) {
        return memberService.list(page, limit);
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(Member member) {
        memberService.saveOrUpdate(member);
    }

    @PostMapping("/suoding")
    @ResponseBody
    public void suoding(String username) {
        redisTemplate.delete("err-" + username);
        redisTemplate.opsForValue().set("err-" + username, 5);
    }

    @PostMapping("/jiesuo")
    @ResponseBody
    public void jiejue(String username) {
        redisTemplate.delete("err-" + username);
    }
}
