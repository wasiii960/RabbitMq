package com.learn.rabbitmq;

import com.learn.rabbitmq.consumer.Consumer;
import com.learn.rabbitmq.publisher.Publisher;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RabbitMqApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(RabbitMqApplication.class, args);
		Publisher publisher = new Publisher();
		publisher.publishMessage("Hello to the real world");
		JSONObject json = new JSONObject();

		json.put("from_date","01-01-2001");
		json.put("to_date","02-02-2001");
		json.put("email","xyz@gmail.com");
		publisher.publishJsonMessage(json);
		publisher.publishMessageUsingDirectExchange("Hello to the real world","mobile");
		Consumer consumer = new Consumer();
		consumer.consumeMessage();
		consumer.consumeMessage("Mobile");
	}

}
