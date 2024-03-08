package com.situ.mallsdauweb.service.impl;

import cn.hutool.core.util.IdUtil;
import com.situ.mallsdauweb.entity.*;

import com.situ.mallsdauweb.mapper.*;
import com.situ.mallsdauweb.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.situ.mallsdauweb.util.RequestUtil;
import com.situ.mallsdauweb.vo.OrderVO;
import org.apache.activemq.ScheduledMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;
import javax.print.attribute.standard.Destination;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderAddressMapper orderAddressMapper;
    @Autowired
    private MemberAddressMapper memberAddressMapper;

//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    @Transactional
    public Integer saveOrder(Integer addId, String cartIds) {
        //生成一个OrderInfo
        OrderInfo oi = new OrderInfo();

        oi.setCode(IdUtil.getSnowflake().nextIdStr());//雪花算法
        oi.setCreateTime(LocalDateTime.now());
        oi.setMemberId(RequestUtil.getCurrent().getId());
        oi.setStatus("待支付");

        BigDecimal total = new BigDecimal("0.00");

        for (String id : cartIds.split(",")) {
            Cart cart = cartMapper.selectById(Integer.parseInt(id));
            Product product = productMapper.selectById(cart.getProductId());

            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(cart.getAmount())));
        }
        oi.setPrice(total);
        baseMapper.insert(oi);

        for (String id : cartIds.split(",")) {
            OrderDetail od = new OrderDetail();

            Cart cart = cartMapper.selectById(Integer.parseInt(id));
            Product product = productMapper.selectById(cart.getProductId());

            od.setAmount(cart.getAmount());
            od.setPrice(product.getPrice());
            od.setProductId(cart.getProductId());
            od.setOrderId(oi.getId());

            orderDetailMapper.insert(od);
        }

        MemberAddress ma = memberAddressMapper.selectById(addId);

        OrderAddress oa = new OrderAddress();
        oa.setOrderId(oi.getId());

        BeanUtils.copyProperties(ma, oa);
        oa.setId(null);
        orderAddressMapper.insert(oa);

        for (String id : cartIds.split(",")) {
            cartMapper.deleteById(Integer.parseInt(id));
        }
        //推送消息
        System.out.println(new Date() + "发送一个消息" + oi.getId());
//        delaySend(new ActiveMQQueue("order.save"), oi.getId(), 15 * 60 * 1000L);
        return oi.getId();
    }

    @Override
    public void updateStatus(String code, String status) {
        baseMapper.updateStatus(code, status);
    }

    @Override
    public List<OrderVO> selectByStatus(String status) {

        List<OrderVO> orderVOList = new ArrayList<>();

        //先查到所有符合条件的订单
        List<OrderInfo> orderInfos = orderInfoMapper.selectAllByStatus(status);
        for (OrderInfo orderInfo : orderInfos) {
            List<Product> productList = new ArrayList<>();
            OrderVO orderVO = new OrderVO();
            orderVO.setCode(orderInfo.getCode());
            orderVO.setStatus(orderInfo.getStatus());
            orderVO.setCreateTime(orderInfo.getCreateTime());
            orderVO.setPrice(orderInfo.getPrice());
            orderVO.setUsername(RequestUtil.getCurrent().getUsername());
//            orderVO.setUsername("admin");
            //获取到每个订单的ID
            Integer orderInfoId = orderInfo.getId();
            List<OrderDetail> orderDetails = orderDetailMapper.searchAllByOrderId(orderInfoId);
            for (OrderDetail orderDetail : orderDetails) {
                Integer productId = orderDetail.getProductId();
                Product product = productMapper.selectById(productId);
                productList.add(product);
            }
            orderVO.setProduct(productList);
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

//    private <T extends Serializable> void delaySend(ActiveMQQueue queue, Integer data, Long time) {
//        Connection conn = null;
//        Session session = null;
//        MessageProducer producer = null;
//
//        ConnectionFactory connectionFactory = jmsMessagingTemplate.getConnectionFactory();
//        try {
//            conn = connectionFactory.createConnection();
//            conn.start();
//            session = conn.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//            //创建一个生产者
//            producer = session.createProducer(queue);
//            producer.setDeliveryMode(JmsProperties.DeliveryMode.PERSISTENT.getValue());
//            ObjectMessage message = session.createObjectMessage(data);
//            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
//            producer.send(message);
//            session.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (producer != null) {
//                    producer.close();
//                }
//                if (session != null) {
//                    session.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ignored) {
//
//            }
//        }
//    }


}
