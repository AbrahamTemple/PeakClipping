package com.spring.msadmin.dao;

import com.spring.msadmin.entity.MsOrder;
import com.spring.msadmin.exception.OrderException;
import com.spring.msadmin.service.IMsOrderService;
import com.spring.msadmin.util.RedisUtil;
import com.spring.msadmin.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.29
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Slf4j
@Service
public class OrderDao {

    @Resource
    RedisUtil redisUtil;
    @Resource
    IMsOrderService iMsOrderService;

    public RestResponse<MsOrder> get(String pid) {
        MsOrder order = (MsOrder) redisUtil.get(pid);
        if(order != null) {
            log.info("订单在Redis中被查到");
            return new RestResponse<MsOrder>(HttpStatus.OK.value(), HttpStatus.OK.toString(),order);
        }
        order = iMsOrderService.getOrderByPid(pid);
        if (order != null){
            log.info("订单在Mysql中被查到");
            return new RestResponse<MsOrder>(HttpStatus.OK.value(), HttpStatus.OK.toString(),order);
        } log.info("找不到该订单信息");
        return new RestResponse<MsOrder>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),null);
    }
}
