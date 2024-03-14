package com.situ.mallsdau1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.Category;
import com.situ.mallsdau1.entity.Member;
import com.situ.mallsdau1.mapper.MemberMapper;
import com.situ.mallsdau1.service.IMemberService;
import com.situ.mallsdau1.vo.ProductVO;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2023/6/10
 * @Time: 8:28
 * @Description:
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public TableVO list(Integer page, Integer limit,String k) {
        TableVO vo = new TableVO();
        PageHelper.startPage(page, limit);
        LambdaQueryWrapper<Member> memberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(k)){
            memberLambdaQueryWrapper.like(Member::getUsername,k) ;
        }
        List<Member> members = memberMapper.selectList(memberLambdaQueryWrapper);
        vo.setData(members);
        vo.setCount(new PageInfo<>(members).getTotal());
        vo.setCode(0);
        return vo;
    }
}
