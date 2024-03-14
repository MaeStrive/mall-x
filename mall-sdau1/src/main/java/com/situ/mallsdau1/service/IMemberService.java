package com.situ.mallsdau1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdau1.entity.Member;
import com.situ.mallsdau1.vo.TableVO;

/**
 * @Author: Mae
 * @Date: 2023/6/10
 * @Time: 8:27
 * @Description:
 */
public interface IMemberService extends IService<Member> {

    TableVO list(Integer page, Integer limit,String k);

}
