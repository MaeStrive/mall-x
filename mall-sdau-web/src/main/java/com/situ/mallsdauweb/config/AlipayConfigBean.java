package com.situ.mallsdauweb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//用此类一次性注入所有有关alipay的相关参数
@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfigBean {
    private String appId;
    private String privateKey;
    private String PublicKey;
    private String serverUrl;
    private String notifyUrl;

}
