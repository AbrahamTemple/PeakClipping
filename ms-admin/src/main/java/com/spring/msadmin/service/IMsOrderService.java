package com.spring.msadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spring.msadmin.entity.MsOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Abraham
 * @since 2021-04-29
 */
public interface IMsOrderService extends IService<MsOrder> {
    public MsOrder getOrderByPid(String pid);
    public boolean insert(MsOrder order);
}
