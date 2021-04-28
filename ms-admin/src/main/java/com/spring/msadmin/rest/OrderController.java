package com.spring.msadmin.rest;

import com.spring.msadmin.dao.MqDao;
import com.spring.msadmin.dao.OrderDao;
import com.spring.msadmin.entity.MsOrder;
import com.spring.msadmin.exception.OrderException;
import com.spring.msadmin.rabbitmq.MqService;
import com.spring.msadmin.service.IMsOrderService;
import com.spring.msadmin.util.RedisUtil;
import com.spring.msadmin.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.29
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    MqDao mqDao;

    @Resource
    OrderDao orderDao;

    @RequestMapping("/set/{user}/{spend}")
    public RestResponse<String> addOrder(@PathVariable(value = "user") String user, @PathVariable(value = "spend") Integer spend){
        return mqDao.add(user,spend);
    }

    @RequestMapping("/get/{pid}")
    public RestResponse<MsOrder> getOrder(@PathVariable(value = "pid") String pid) {
        return orderDao.get(pid);
    }

}
