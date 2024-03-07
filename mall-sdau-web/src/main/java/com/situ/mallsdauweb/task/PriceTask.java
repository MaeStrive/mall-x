package com.situ.mallsdauweb.task;

import com.situ.mallsdauweb.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//统计营业额定时任务
@Component
public class PriceTask {
    @Autowired
    private IOrderInfoService orderInfoService;
    //cron表达式
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {

        //定时任务执行的代码中 不要获取当前登录用户
        LocalDate ld=LocalDate.now().plusDays(-1);
        //   DateTimeFormatter dataTimeFormatter=DateTimeFormatter;
        //调用service统计总金额
        BigDecimal price =BigDecimal.valueOf(4998);
        //发短信
        System.out.println("昨天的营收额："+price);
    }
}