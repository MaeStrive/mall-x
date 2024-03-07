package com.situ.mallsdauweb.Interceptor;

import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.util.RequestUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
//请求进入controller之前 拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Member m= RequestUtil.getCurrent();
        if(m!=null){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
