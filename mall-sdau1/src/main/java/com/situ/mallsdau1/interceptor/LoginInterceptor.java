package com.situ.mallsdau1.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
//请求进入controller之前 拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //返回 true就是允许进入 controller
        //session
        Object obj=request.getSession().getAttribute("mark");
        //返回 false 不允许
        if(obj!=null){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
