package com.situ.mallsdauweb.service;

import com.situ.mallsdauweb.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
