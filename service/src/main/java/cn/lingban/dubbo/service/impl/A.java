package cn.lingban.dubbo.service.impl;

import cn.lingban.dubbo.common.mq.ActiveMQMessage;

import javax.jms.*;

/**
 * Created by chao on 2016/10/26.
 */
public class A {


    public static void consumeMessage() {
        new ActiveMQMessage("admin", "admin", "tcp://192.168.2.46:61616", "test-topic").consumeMessage(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    if (null != message) {
                        System.out.println("收到消息" + ((ObjectMessage) message).getObject().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void produceMessage() {
        new ActiveMQMessage("admin", "admin", "tcp://192.168.2.46:61616", "test-topic").produceMessage(new String("ss"));
    }

    public static void main(String[] args) {
        //produceMessage();
        System.out.println("-----");
        consumeMessage();
        System.out.println("=====");
        //consumeMessage();
    }

}
