package com.situ.mallsdauweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.mapper.MemberMapper;
import com.situ.mallsdauweb.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.util.RequestUtil;
import com.situ.mallsdauweb.util.ResultVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


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

    @Override
    public ResultVO<?> register(String username, String password,String tel,String name) {
        //查询是否有账号
        QueryWrapper<Member> queryWrap=new QueryWrapper<>();
        queryWrap.eq("username", username);
        List<Member> members = baseMapper.selectList(queryWrap);
        if (members != null && members.size() > 0){
            return ResultVO.error("该账号已存在!",-1);
        }
        Member member=new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setTel(tel);
        member.setName(name);
        member.setCreateTime(LocalDateTime.now());
        baseMapper.insert(member);
        return ResultVO.ok();
    }
}
