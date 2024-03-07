package com.situ.mallsdauweb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.situ.mallsdauweb.config.AlipayConfigBean;
import com.situ.mallsdauweb.entity.OrderInfo;
import com.situ.mallsdauweb.mapper.OrderInfoMapper;
import com.situ.mallsdauweb.service.IPayService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements IPayService {
@Autowired
private OrderInfoMapper orderInfoMapper;
@Autowired
private AlipayConfigBean configBean;

    @Override
    public String pay(Integer id) throws AlipayApiException {
        OrderInfo oi=orderInfoMapper.selectById(id);
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayClient alipayClient = new DefaultAlipayClient(configBean.getServerUrl(),configBean.getAppId(),configBean.getPrivateKey(),"json","UTF-8",configBean.getPublicKey(),"RSA2");
        request.setNotifyUrl(configBean.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no",oi.getCode());
        bizContent.put("total_amount", oi.getPrice());
        bizContent.put("subject", "小米商城订单");
        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            return response.getQrCode();
        }
        return "";
    }
}
