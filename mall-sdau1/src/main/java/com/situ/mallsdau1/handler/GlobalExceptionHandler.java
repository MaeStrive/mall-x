package com.situ.mallsdau1.handler;

import com.situ.mallsdau1.exception.BusinessException;

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
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handler1(BusinessException e){
        Map<String,String> map=new HashMap<>();
        map.put("msg",e.getMsg());
return ResponseEntity.status(500).body(map);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handler2(Exception e) {
        Map<String,String> map=new HashMap<>();
        map.put("msg","服务器内部异常");
        return ResponseEntity.status(500).body(map);
    }
}
