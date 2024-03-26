package com.situ.mallsdauweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.situ.mallsdauweb.entity.MemberAddress;
import com.situ.mallsdauweb.entity.OrderInfo;
import com.situ.mallsdauweb.mapper.MemberAddressMapper;
import com.situ.mallsdauweb.service.IOrderInfoService;
//import com.situ.mallsdauweb.service.IPayService;
import com.situ.mallsdauweb.vo.CartVO;
import com.situ.mallsdauweb.vo.OrderHhhVO;
import com.situ.mallsdauweb.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderInfoService orderInfoService;
    //    @Autowired
//    private IPayService payService;
    @Autowired
    private MemberAddressMapper memberAddressMapper;

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderVO> order(String status) {
        if (status == null) {
            status = "";
        } else if (status.equals("0")) {
            status = "";
        } else if (status.equals("2")) {
            status = "已支付";
        } else if (status.equals("4")) {
            status = "已取消";
        }
        List<OrderVO> orderVOList = orderInfoService.selectByStatus(status);
        return orderVOList;
    }


    @PostMapping("/save")
    //参数一：选择的地址ID，参数二：购物车中选择的IDs
    public String saveOrder(Integer addId, String cartIds, Model model) {
        OrderHhhVO orderHhhVO = orderInfoService.saveOrder(addId, cartIds);
        model.addAttribute("address", orderHhhVO.getMemberAddress());
        model.addAttribute("price", orderHhhVO.getPrice());
        //根据主键获取支付二维码
//        try {
//            String qrCode = payService.pay(id);
//
//            System.out.println(qrCode);
//            model.addAttribute("qrCode", qrCode);
//            model.addAttribute("id", id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("对接支付宝失败，未能获得二维码");
//        }
//        //提示订单生成成功，可以去付款页面
        return "payment";
    }

    @GetMapping("/status")
    @ResponseBody
    public String status(Integer id) {
        OrderInfo oi = orderInfoService.getById(id);
        return oi.getStatus();
    }

    @JmsListener(destination = "order.save")
    public void checkStatus(Integer id) {
        //根据id 查订单
        //判断是否  还是待支付-》已取消
        OrderInfo oi = orderInfoService.getById(id);
        if (oi.getStatus().equals("待支付")) {
            orderInfoService.updateStatus(oi.getCode(), "已取消");
        }
    }

    /**
     * 去订单页面
     *
     * @return
     */
    @GetMapping("/order")
    public String orderPage() {
        return "order";
    }


}
