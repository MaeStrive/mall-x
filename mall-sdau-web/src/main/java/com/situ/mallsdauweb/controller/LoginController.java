package com.situ.mallsdauweb.controller;

import com.situ.mallsdauweb.service.IMemberService;
//import com.situ.mallsdauweb.util.SendSmsUtil;
import com.situ.mallsdauweb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private RedisTemplate redisTemplate;

    //请求返回登陆页面
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //请求验证用户密码是否正确
//    @PostMapping("/login")
//    public String doLogin(String username, String password) {
//        boolean b = memberService.check(username, password);
//        if (b) {
//            //请求转发：请求发送一次
//            //重定向：请求发两次
//            return "redirect:/index";
//        } else {
//            return "login";
//        }
//    }

    @PostMapping("/login")
    public String doLogin(String username, String password, Model model) {
        //先判断是不是已经失败5次
        Object obj = redisTemplate.opsForValue().get("err-" + username);
        if (obj != null && (Integer) obj == 5) {
            model.addAttribute("errMsg", "账号已锁定，请2小时后再尝试");
            return "login";
        }

        boolean b = memberService.check(username, password);
        if (b) {
            //成功，清楚之前缓存的错误次数
            redisTemplate.delete("err-" + username);
            //请求转发：请求发送一次
            //重定向：请求发两次
            return "redirect:/index";
        } else {
            //相关判断 用户名密码错误的次数
            //根据key取出之前缓存的数据

            if (obj == null) {
                //说明是第一次失败
                redisTemplate.opsForValue().set("err-" + username, 1, 2, TimeUnit.HOURS);//2小时
            } else {
                Integer num = (Integer) obj;//之前失败的次数
                redisTemplate.opsForValue().set("err-" + username, num + 1);
            }
            model.addAttribute("errMsg", "用户名或密码错误");
            return "login";
        }
    }

    //注册前发验证码
    @PostMapping("/sendCode")
    @ResponseBody
    public void sendCode(String tel) {
        //判断手机号是否已经注册过

        double d = ((int) (Math.random() * 900000)) + 100000;//大于等于0，小于1

//        SendSmsUtil.sendMessge(tel, String.valueOf(d));
        redisTemplate.opsForValue().set(tel, d);
    }

    @PostMapping("/register")
    public String register(String tel, String code, Model model) {
        Object obj = redisTemplate.opsForValue().get(tel);
        if (obj != null && ((String) obj).equals(code)) {
            //调用service注册新账号

        }
        return "";
    }

    @GetMapping("/logout")
    public String logout(){
        RequestUtil.getSession().removeAttribute("current");
        return "login";
    }
}
