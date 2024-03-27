package com.situ.mallsdauweb.controller;


import com.situ.mallsdauweb.entity.Member;
import com.situ.mallsdauweb.entity.MemberAddress;
import com.situ.mallsdauweb.service.IMemberAddressService;
import com.situ.mallsdauweb.entity.MemberAddress;
import com.situ.mallsdauweb.service.IMemberAddressService;
import com.situ.mallsdauweb.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Controller
@RequestMapping("/")
public class MemberAddressController {

    @Autowired
    private IMemberAddressService iMemberAddressService;

    @PostMapping("/member-address/save")
    @ResponseBody
    public void save(@RequestBody MemberAddress memberAddress) {
        Member current = RequestUtil.getCurrent();
        memberAddress.setMemberId(current.getId());
        iMemberAddressService.save(memberAddress);
    }

    @GetMapping("/member-address")
    public String index(Model model) {
        List<MemberAddress> addresses = iMemberAddressService.list();

        model.addAttribute("addressList", addresses);
        return "address";
    }

    @GetMapping("/member-address/delete")
    @ResponseBody
    public Integer delete(Integer id) {
        iMemberAddressService.removeById(id);
        return id;
    }
}
