package com.learn.rabbitmq.publisher;

import com.learn.rabbitmq.config.QueueConnection;
import com.rabbitmq.client.Channel;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Wasif.Ali on 04/07/2024
 * @project TestKitDataService
 */
public class Publisher {
    public void publishMessage(String message) throws IOException, TimeoutException {
        QueueConnection connection = new QueueConnection();
        Channel channel =connection.createChannel();
        channel.basicPublish("","Queue-1",null,message.getBytes());
        channel.close();
    }
    public void publishJsonMessage(JSONObject json) throws IOException, TimeoutException {
        QueueConnection connection = new QueueConnection();
        Channel channel = connection.createChannel();
        channel.basicPublish("","Queue-1",null,json.toString().getBytes());
    }
}