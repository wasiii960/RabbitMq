package com.learn.rabbitmq;

import com.learn.rabbitmq.consumer.Consumer;
import com.learn.rabbitmq.publisher.Publisher;
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
		Consumer consumer = new Consumer();
		consumer.consumeMessage();
	}

}
