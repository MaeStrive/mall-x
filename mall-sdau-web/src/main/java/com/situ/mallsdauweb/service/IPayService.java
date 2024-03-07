package com.situ.mallsdauweb.service;

import com.alipay.api.AlipayApiException;

public interface IPayService {
    String pay(Integer id) throws AlipayApiException;
}
