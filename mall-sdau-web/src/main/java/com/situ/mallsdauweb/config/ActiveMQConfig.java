package com.situ.mallsdauweb.config;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {
    @Bean
    public ActiveMQConnectionFactory factory(@Value("${spring.activemq.broker-url}")String url){
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(url);
        factory.setTrustAllPackages(true);
        return factory;
    }
}
