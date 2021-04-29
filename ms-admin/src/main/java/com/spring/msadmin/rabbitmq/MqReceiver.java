package com.spring.msadmin.rabbitmq;

import com.spring.msadmin.entity.MsOrder;
import com.spring.msadmin.exception.OrderException;
import com.spring.msadmin.service.IMsOrderService;
import com.spring.msadmin.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Component
public class MqReceiver {

    @Resource
    RedisUtil redisUtil;

    @Resource
    IMsOrderService iMsOrderService;

    @Transactional
    @RabbitHandler
    @RabbitListener(queues = "ms_order")
    public void MsOrderMessage(MsOrder order) {
        boolean created = iMsOrderService.save(order);
        if(created) {
            redisUtil.set(order.getPid(), order, 1800);
            log.info("订单--"+order.getPid()+"--已被缓存,半小时后自动清除");
        } else {
            log.info("订单提交失败,事务回滚...");
            throw new OrderException("订单提交失败!");
        }
    }


}
