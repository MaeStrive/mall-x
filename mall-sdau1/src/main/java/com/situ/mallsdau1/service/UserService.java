package com.situ.mallsdau1.service;

import com.situ.mallsdau1.entity.User;
import com.situ.mallsdau1.mapper.UserMapper;
import com.situ.mallsdau1.vo.TableVO;

import javax.servlet.http.HttpSession;

public interface UserService {

    TableVO select(Integer limit,Integer page,String k);

    void delete(Integer userId);

    void save(User user);

    User selectById(Integer id);

    boolean check(String username, String password, HttpSession session);
}
