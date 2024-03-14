package com.situ.mallsdau1.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mallsdau1.entity.OrderInfo;
import com.situ.mallsdau1.mapper.OrderInfoMapper;
import com.situ.mallsdau1.service.OrderInfoService;
import com.situ.mallsdau1.service.OrderInfoService;
import com.situ.mallsdau1.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/order")
@Controller
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @RequestMapping("/page")
    public String user(){
        return "order";
    }
    @RequestMapping("/list")
    @ResponseBody
    public TableVO list(@RequestParam Integer limit,@RequestParam Integer page,@RequestParam(value="keyword",required=false) String k){
        return orderInfoService.select(limit, page,k);
    }
    @RequestMapping("/orderlist")
    @ResponseBody
    public TableVO orderlist(@RequestParam Integer limit, @RequestParam Integer page,@RequestParam(value="keyword",required=false) String k ){


        /**
        *@作者：大叔azhe
        *@api：PageHelper.startPage(page,limit);
         * 放在orderInfoService.list();前面可以使的分页自动实现，无需使用.page()
        *@创建时间：21:42 2024/3/13
        */
        PageHelper.startPage(page,limit);
        LambdaQueryWrapper<OrderInfo> orderInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(k)) {
            orderInfoLambdaQueryWrapper.like(OrderInfo::getCode,k);
        }
        List<OrderInfo> list = orderInfoService.list(orderInfoLambdaQueryWrapper);
        TableVO tableVO = new TableVO();
        tableVO.setData(list);
        tableVO.setCount(new PageInfo<>(list).getTotal());
        tableVO.setCode(0);
        return tableVO;
    }
   // @RequestMapping(value="/del",method= RequestMethod.POST)
    @PostMapping("/del")
    @ResponseBody
    public void del(Integer id){
        orderInfoService.removeById(id);

    }

    @PostMapping("/dellist")
    @ResponseBody
    public void dellist(@RequestBody LinkedList<OrderInfo> data){
        System.out.println(data);
        orderInfoMapper.deleteBatchIds(data.stream().map((item)->item.getId()).collect(Collectors.toList()));

    }

    @PostMapping("/save")
    @ResponseBody
    public void save(OrderInfo user){
        orderInfoService.save(user);

    }
    @GetMapping("/info")
    @ResponseBody
    public OrderInfo selectById(Integer id){
        return orderInfoService.getById(id);
    }


    @GetMapping("/count")
    @ResponseBody
    public Long userCount(){

        Long users = orderInfoService.count();
        return users;
    }
}
