package com.learn.rabbitmq.service;

import com.learn.rabbitmq.dto.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wasif.Ali on 10/07/2024
 * @project TestKitDataService
 */
@Service
public class RabbitMqService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void convertAndSend(String name){
        Person p = new Person(1L,name);
        rabbitTemplate.convertAndSend("Mobile",p);
    }
}
