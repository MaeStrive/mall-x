package com.situ.mallsdauweb.service;

import com.situ.mallsdauweb.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.mallsdauweb.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface ICartService extends IService<Cart> {

    void addCart(Integer id);

    List<CartVO> cartList();

    List<CartVO> confirmCartList(String cartIds);
}
