package com.spring.msadmin.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    /**
     * 接收消息的方法
     **/
    public void receiveMessage(String message){
        System.out.println("receiveMessage接收到的消息："+message);
    }

    /**
     * 接收消息的方法
     **/
    public void receiveMessage2(String message){
        System.out.println("receiveMessage接收到的消息："+message);
    }


}