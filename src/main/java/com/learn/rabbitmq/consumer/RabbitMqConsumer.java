package com.learn.rabbitmq.consumer;

import com.learn.rabbitmq.dto.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Wasif.Ali on 10/07/2024
 * @project TestKitDataService
 */
@Service
public class RabbitMqConsumer {

    @RabbitListener(queues = "Mobile")
    public void getMessage(Person p){
        System.out.println(p.getName());
    }
}
