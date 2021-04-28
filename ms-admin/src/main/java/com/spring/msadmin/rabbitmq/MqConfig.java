package com.spring.msadmin.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MqConfig {

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public DirectExchange MsExchange(){
        return new DirectExchange("ms_exchange",true,false);
    }

    /**
     * 声明短信队列
     * @return
     */
    @Bean
    public Queue MsQueue(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000);//设置过期时间5秒
        args.put("x-max-length",6);//最新大消息长度
//        args.put("x-dead-letter-exchange","dead_exchange");//绑定死信队列
//        args.put("x-dead-letter-routing-key","dead");//死信交换机有路由key一定要配
        return new Queue("ms_order", true,false,false,args);
    }

    /**
     * 绑定交换机与队列
     * @return
     */
    @Bean
    public Binding MsBinding(){
        return BindingBuilder.bind(MsQueue()).to(MsExchange()).with("write");
    }

}
