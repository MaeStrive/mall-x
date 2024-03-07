package com.situ.mallsdauweb.util;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

//fasongduanxingongjulei
public class SendSmsUtil {
    public static Client createClient() throws Exception {
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId("LTAI5t5kYWC7n1p4KrwSMRxJ")
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret("U9twXjG9ve9wvqHEfkdaRZxm6Mcnuj");
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }
    public static void sendMessge(String tel,String content) {
        // 请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID 和 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例使用环境变量获取 AccessKey 的方式进行调用，仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        try{
            Client client = createClient();
            Map<String,String> map=new HashMap<>();
            map.put("code",content);

            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(tel)
                    .setSignName("your_value")//签名,审核通过才能用
                    .setTemplateCode("")//审核通过才给
                    .setTemplateParam(new ObjectMapper().writeValueAsString(map));//审核通过才给模板
            // 复制代码运行请自行打印 API 的返回值
            client.sendSmsWithOptions(sendSmsRequest, new RuntimeOptions());
        } catch (Exception _error) {
            System.out.println("发送短信失败");
            _error.printStackTrace();
        }
    }
}
