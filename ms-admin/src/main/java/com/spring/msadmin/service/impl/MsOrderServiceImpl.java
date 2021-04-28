package com.spring.msadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.msadmin.entity.MsOrder;
import com.spring.msadmin.mapper.MsOrderMapper;
import com.spring.msadmin.service.IMsOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Abraham
 * @since 2021-04-29
 */
@Service
public class MsOrderServiceImpl extends ServiceImpl<MsOrderMapper, MsOrder> implements IMsOrderService {

    @Override
    public MsOrder getOrderByPid(String pid) {
        return super.getOne(new QueryWrapper<MsOrder>(null).eq("pid",pid));
    }

    @Override
    public boolean insert(MsOrder order) {
        return super.save(order);
    }

}
