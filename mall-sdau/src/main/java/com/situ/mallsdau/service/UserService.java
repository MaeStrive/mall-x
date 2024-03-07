package com.situ.mallsdau.service;

import com.situ.mallsdau.entity.User;
import com.situ.mallsdau.vo.TableVO;

import javax.servlet.http.HttpSession;

public interface UserService {

    TableVO select(Integer limit, Integer page, String k);

    void delete(Integer userId);

    void save(User user);

    User selectById(Integer id);

    boolean check(String username, String password, HttpSession session);
}
