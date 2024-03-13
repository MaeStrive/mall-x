package com.situ.mallsdauweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdauweb.entity.Cart;
import com.situ.mallsdauweb.entity.MemberAddress;
import com.situ.mallsdauweb.service.ICartService;
import com.situ.mallsdauweb.service.IMemberAddressService;
import com.situ.mallsdauweb.util.RequestUtil;
import com.situ.mallsdauweb.vo.CartTotalVO;
import com.situ.mallsdauweb.vo.CartVO;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
@Controller
@RequestMapping("/")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IMemberAddressService memberAddressService;

    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartVO> list = cartService.cartList();
        model.addAttribute("carts", list);
        return "cart";
    }

    @PostMapping("/cart/add")
    @ResponseBody
    public void addCart(Integer id) {
        cartService.addCart(id);
    }

    @PostMapping("/cart/del")
    @ResponseBody
    public void del(Integer id) {
        cartService.removeById(id);
    }

    @PostMapping("/cart/amount")
    @ResponseBody
    public void amount(Integer id, Integer amount) {
        Cart c = new Cart();
        c.setId(id);
        c.setAmount(amount);
        cartService.updateById(c);
    }

    @GetMapping("/confirm")
    public String confirm(String cartIds, Model model) {
        //带上当前用户的地址列表
        QueryWrapper<MemberAddress> queryWrapper = new QueryWrapper<>();

        List<MemberAddress> addressList = memberAddressService.list(queryWrapper);

        queryWrapper.eq("member_id", RequestUtil.getCurrent().getId());
        //带上cardIds这些购物车的数据
        List<CartVO> list = cartService.confirmCartList(cartIds);
        model.addAttribute("addressList", addressList);
        model.addAttribute("carts", list);
        System.out.println(list);
        CartTotalVO cartTotalVO=new CartTotalVO();
        BigDecimal price=new BigDecimal(0);
        Integer total=0;
        for (CartVO cart:list) {
            BigDecimal price1 = cart.getPrice();
            Integer amount = cart.getAmount();
            BigDecimal multiply = price1.multiply(new BigDecimal(amount));
            price=price.add(multiply);
            total+=cart.getAmount();
        }
        cartTotalVO.setTotal(total);
        cartTotalVO.setPrice(price);
        model.addAttribute("cartTotalVO", cartTotalVO);

        return "confirm";
    }
}
