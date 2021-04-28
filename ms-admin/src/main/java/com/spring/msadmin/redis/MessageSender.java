package com.spring.msadmin.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class MessageSender {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发布消息
     *
     * @param channel 消息信道
     * @param message 消息内容
     */
    public void sendMessage(String channel, String message) {
        stringRedisTemplate.convertAndSend(channel, message);
    }

    /**
     * 发布消息的方法
     */
    public void startSend() {
        this.sendMessage("topic1", "1号主题推送消息" + UUID.randomUUID().toString());
        this.sendMessage("topic2", "2号主题推送消息"+ UUID.randomUUID().toString());
        this.sendMessage("topic2", "1号主题推送消息" + UUID.randomUUID().toString());
        this.sendMessage("topic1", "2号主题推送消息"+ UUID.randomUUID().toString());
        this.sendMessage("topic2", "1号主题推送消息" + UUID.randomUUID().toString());
        this.sendMessage("topic1", "2号主题推送消息"+ UUID.randomUUID().toString());
    }

}
