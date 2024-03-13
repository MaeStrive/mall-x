package com.situ.mallsdauweb.service;

import com.situ.mallsdauweb.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdauweb.util.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
public interface IMemberService extends IService<Member> {

    boolean check(String username, String password);

    ResultVO<?> register(String username, String password,String tel,String name);

    ResultVO<?> updatePassword(String newpsd, String orignpsd,Member member);
}
