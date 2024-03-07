package com.situ.mallsdau1.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.User;
import com.situ.mallsdau1.mapper.UserMapper;
import com.situ.mallsdau1.service.UserService;
import com.situ.mallsdau1.vo.TableVO;
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
    public TableVO select(Integer limit, Integer page,String k) {

        TableVO vo = new TableVO();
        vo.setCode(0);
        vo.setMsg("");

//pageHelper
        PageHelper.startPage(page,limit);
        List<User> list =userMapper.selectUsers(k);
        vo.setCount(new PageInfo(list).getTotal());
       vo.setData(list);
        return vo;
    }

    @Override
    public void delete(Integer userId) {
        userMapper.delete(userId );
    }

    @Override
    public void save(User user) {
        if(user.getId()==null){//新增保存
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(0);
        userMapper.insert(user);
        } else{
            userMapper.update(user);
        }
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean check(String username, String password, HttpSession sesssion) {
       User user= userMapper.selectByUsername(username);
//        if(user==null){//用户名不对
//            return false;
//        }
//        //验证密码
//       if(user.getPassword().equals(password)){
//           return true;
//       }
//        return false;
      boolean b=user !=null &&user.getPassword().equals(password);
      if(b){//标记打在session
          sesssion.setAttribute("mark",user);
      }
       return b;
    }
}
