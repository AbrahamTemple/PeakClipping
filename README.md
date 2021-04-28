# 基于RabbitMQ和Redis做的流量削峰简单版

我们都明白某一瞬间突发的高峰访问量全打Mysql上将是容易冲垮数据库的

该项目的设计想法是在Mysql的上层以添加中间件的方式给数据库加以保护

在数据读的时候先查Redis，查不到才会查数据库

在数据写时会先请求RabbitMQ发送消息，再在队列里完成mysql业务及Redis的缓存

设计蓝图如下

![Screenshot](Result/main.png)

## 核心代码块
