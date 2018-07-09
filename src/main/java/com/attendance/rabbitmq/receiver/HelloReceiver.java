package com.attendance.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by pengm on 2018/5/24.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void receiver(String hello) {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Receiver"+i+"  : " + hello);
        }

    }
   /* @RabbitHandler
    public void process2(String hello) {
        System.out.println("Receiver2  : " + hello);
    }*/
}