package com.situ.mallsdau1.controller;

import com.situ.mallsdau1.entity.Member;
import com.situ.mallsdau1.service.IMemberService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        memberService.save(member);
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
