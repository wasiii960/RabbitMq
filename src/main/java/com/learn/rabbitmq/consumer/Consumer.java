package com.learn.rabbitmq.consumer;

import com.learn.rabbitmq.config.QueueConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Wasif.Ali on 04/07/2024
 * @project TestKitDataService
 */
public class Consumer {

    public void consumeMessage() throws IOException, TimeoutException {
        QueueConnection queueConnection = new QueueConnection();
        Channel channel = queueConnection.createChannel();
        DeliverCallback deliverCallback = (consumerTag,delivery)->{
           String message = delivery.getBody().toString();
            System.out.println("message + "+ message);
        };
        channel.basicConsume("Queue-1",true,deliverCallback,consumerTag -> {});
    }
}
