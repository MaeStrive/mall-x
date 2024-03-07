package com.situ.mallsdauweb.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.situ.mallsdauweb.config.AlipayConfigBean;
import com.situ.mallsdauweb.entity.OrderDetail;
import com.situ.mallsdauweb.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/")
public class NotifyController {
    @Autowired
    private AlipayConfigBean configBean;
    @Autowired
    private IOrderInfoService orderInfoService;
    @PostMapping("/notify")
    @ResponseBody
    public String alipayNotify(HttpServletRequest request) throws AlipayApiException {
        //获取支付宝POST过来反馈信息，将异步通知中收到的待验证所有参数都存放到map中
        Map< String , String > params = new HashMap< String , String >();
        Map requestParams = request.getParameterMap();
        for(Iterator iter = requestParams.keySet().iterator(); iter.hasNext();){
            String name = (String)iter.next();
            String[] values = (String [])requestParams.get(name);
            String valueStr = "";
            for(int i = 0;i < values.length;i ++ ){
                valueStr =  (i==values.length-1)?valueStr + values [i]:valueStr + values[i] + ",";
            }
            params.put (name,valueStr);
        }
        boolean  signVerified = AlipaySignature.rsaCheckV1(params, configBean.getPublicKey(), "UTF-8","RSA2") ;
        if (signVerified){
            // TODO 验签成功后
            //按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success
            String code=params.get("out_trade_no");
            //根据code修改订单状态->已支付
           orderInfoService.updateStatus(code,"已支付 ");
        } else {
            // TODO 验签失败则记录异常日志，并在response中返回fail.
        }
        return "SUCCESS";
    }

}
