package com.situ.mallsdau.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau.entity.User;
import com.situ.mallsdau.mapper.UserMapper;
import com.situ.mallsdau.service.UserService;
import com.situ.mallsdau.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public TableVO select(Integer limit, Integer page, String k) {
        TableVO vo = new TableVO();
        vo.setCode(0);
        vo.setMsg("");
        //PageHelper　starter
        PageHelper.startPage(page, limit);  //这行代码后边的第一次查数据库是分页查询
        List<User> list = userMapper.selectUsers(k);
        vo.setCount(new PageInfo(list).getTotal());
        vo.setData(list);
        return vo;
    }

    @Override
    public void delete(Integer userId) {
        userMapper.delete(userId);
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {//新增保存
            user.setCreateTime(LocalDateTime.now());
            user.setStatus(0);
            userMapper.insert(user);
        } else {
            userMapper.update(user);
        }
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean check(String username, String password, HttpSession session) {
        User user = userMapper.selectByUsername(username);
//        if (user == null) {
//            return false;
//        }
//        if (user.getPassword().equals(password)) {
//            return true;
//        }
//        return false;
        boolean b = user != null && user.getPassword().equals(password);
        if (b) {
            session.setAttribute("mark", user);
        }
        return b;
    }
}
