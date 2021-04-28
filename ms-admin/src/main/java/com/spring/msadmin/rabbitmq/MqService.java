package com.spring.msadmin.rabbitmq;

import com.spring.msadmin.entity.MsOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MqService {

    private final String exchangeName = "ms_exchange";

    @Resource
    private RabbitTemplate rabbitTemplate;

    public String makeOrder(MsOrder order){
        rabbitTemplate.convertAndSend(exchangeName,"write",order);
        return "订单已提交处理，您可以通过订单号--"+order.getPid()+"--查询订单状态";
    }

}
