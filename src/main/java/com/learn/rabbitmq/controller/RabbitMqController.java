package com.learn.rabbitmq.controller;

import com.learn.rabbitmq.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wasif.Ali on 10/07/2024
 * @project TestKitDataService
 */
@Controller
@RequestMapping("/api/v1")
public class RabbitMqController {
    @Autowired
    RabbitMqService service;

    @GetMapping("/test/{name}")
    public ResponseEntity<?> testQueue(@PathVariable(name = "name") String name){
        service.convertAndSend(name);
        return ResponseEntity.ok("Success");
    }
}
