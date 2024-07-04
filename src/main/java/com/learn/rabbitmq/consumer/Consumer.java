package com.learn.rabbitmq.consumer;

import com.learn.rabbitmq.config.QueueConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
           String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(message);
        };
        channel.basicConsume("Queue-1",true,deliverCallback,consumerTag -> {});
    }

    public void consumeMessage(String queueName) throws IOException, TimeoutException {
        QueueConnection queueConnection = new QueueConnection();
        Channel channel = queueConnection.createChannel();
        DeliverCallback deliverCallback = (consumerTag,delivery)->{
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(message);
        };
        channel.basicConsume(queueName,true,deliverCallback,consumerTag -> {});
    }
}
