package com.situ.mallsdauweb.handler;

import com.situ.mallsdauweb.exception.NotLoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//全局异常处理器
//一出异常就进入这里
@ControllerAdvice
public class GlobalExceptionHandler {
//通过不同方法 处理不同异常
    //没登陆出现这个异常
    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity handler3(NotLoginException e){
        Map<String,String> map=new HashMap<>();
        map.put("msg","没登录，请先登录");
return ResponseEntity.status(401).body(map);
    }
@ExceptionHandler(NullPointerException.class)
public ResponseEntity handler2(NullPointerException e) {
e.printStackTrace();

        return null;
}
    @ExceptionHandler(Exception.class)
    public ResponseEntity handler1(Exception e) {
        e.printStackTrace();
        return null;
    }
}
