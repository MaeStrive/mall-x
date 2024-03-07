package com.situ.mallsdauweb.util;

import com.situ.mallsdauweb.entity.Member;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//请求相关的工具类
public class RequestUtil {
    public static HttpServletRequest getRequest(){
        return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static HttpSession getSession(){
        return getRequest().getSession();
    }


    public static Member getCurrent(){
        Object obj=getSession().getAttribute("current");
        if(obj!=null){
            return (Member)obj;
        }
        return null;
    }
}
