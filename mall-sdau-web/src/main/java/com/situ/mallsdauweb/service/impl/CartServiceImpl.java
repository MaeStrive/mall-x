package com.situ.mallsdauweb.service.impl;

import com.situ.mallsdauweb.entity.Cart;
import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.exception.NotLoginException;
import com.situ.mallsdauweb.mapper.CartMapper;
import com.situ.mallsdauweb.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.util.RequestUtil;
import com.situ.mallsdauweb.vo.CartVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Override
    public void addCart(Integer id) {
        Member m = RequestUtil.getCurrent();
        if (m == null) {//没登录点了加入购物车
            throw new NotLoginException();
        }
        Integer memberId = m.getId();


        Cart old = baseMapper.selectByMemberIdAndProductId(memberId, id);


        if (old != null) {//之前加过这个商品
            old.setAmount(old.getAmount() + 1);
            baseMapper.updateById(old);
        } else {
            Cart cart = new Cart();
            cart.setProductId(id);
            cart.setCreateTime(LocalDateTime.now());
            cart.setAmount(1);
            cart.setMemberId(memberId);
            baseMapper.insert(cart);
        }
    }

    @Override
    public List<CartVO> cartList() {
        Member m = RequestUtil.getCurrent();
        return baseMapper.cartList(m.getId());
    }

    @Override
    public List<CartVO> confirmCartList(String cartIds) {
        return baseMapper.selectCarts(cartIds.split(","));

    }


}
