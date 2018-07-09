package com.attendance.rabbitmq.controller;

import com.attendance.rabbitmq.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pengm on 2018/5/24.
 */
@RestController
public class RabbitMqDemoController {

    @Autowired
    private HelloSender helloSender;

    @RequestMapping("/rabbit/demo")
    public String demo(){
        helloSender.send(1);
        return "ok";
    }


}