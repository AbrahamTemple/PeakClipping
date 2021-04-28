package com.spring.msadmin.dao;

import com.spring.msadmin.entity.MsOrder;
import com.spring.msadmin.rabbitmq.MqService;
import com.spring.msadmin.vo.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Service
public class MqDao {

    @Resource
    MqService mqService;

    public RestResponse<String> add(String user, Integer spend){
        String idCode = user + new Date().getTime();
        String pid = UUID.nameUUIDFromBytes(idCode.getBytes()).toString();
        MsOrder order = new MsOrder(user,pid,spend);
        return new RestResponse<String>(HttpStatus.CREATED.value(),HttpStatus.CREATED.toString(),mqService.makeOrder(order));
    }
}
