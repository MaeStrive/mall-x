package com.situ.mallsdauweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.mapper.MemberMapper;
import com.situ.mallsdauweb.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.util.RequestUtil;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Override
    public boolean check(String username, String password) {

        QueryWrapper<Member> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
            Member m=baseMapper.selectOne(queryWrapper);

            boolean b=m!=null&&m.getPassword().equals(password);
        if (b) {//正确，则把当前用户存在session
            RequestUtil.getSession().setAttribute("current",m);
        }
        return b;
    }
}
