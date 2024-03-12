package com.situ.mallsdauweb.util;

import lombok.Data;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2024/3/12
 * @Time: 20:08
 * @Description:
 */
@Data
public class ResultVO<T> {
    private String msg;
    private T data;
    private Integer code=0;

    public ResultVO(T data) {
        this.data = data;
    }
    public ResultVO(){

    }
    public ResultVO(String msg,T data){
        this.msg=msg;
        this.data=data;
    }

    public ResultVO(String msg,T data,Integer code){
        this.msg=msg;
        this.data=data;
        this.code=code;
    }

    public ResultVO(Integer code){
        this.code=code;
    }

    public static<T> ResultVO<T> ok(T data) {
        ResultVO<T> r = new ResultVO<T>();
        r.setCode(200);
        r.setData(data);
        return r;
    }
    public static<T> ResultVO<T> ok(T data,String msg) {
        ResultVO<T> r = new ResultVO<T>();
        r.setCode(200);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static<T> ResultVO<T> ok(String msg) {
        ResultVO<T> r = new ResultVO<T>();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    public static<T> ResultVO<T> ok() {
        ResultVO<T> r = new ResultVO<T>();
        r.setCode(200);
        return r;
    }

    public static<T> ResultVO<T> error(String msg) {
        ResultVO<T> r = new ResultVO<T>();
        r.setMsg(msg);
        return r;
    }

    public static<T> ResultVO<T> error(String msg,Integer code) {
        ResultVO<T> r = new ResultVO<T>();
        r.setMsg(msg);
        r.setCode(code);
        return r;
    }
    public static<T> ResultVO<T> error(Integer code) {
        ResultVO<T> r = new ResultVO<T>();
        r.setCode(code);
        return r;
    }
}
