package com.learn.rabbitmq.dto;

import java.io.Serializable;

/**
 * @author Wasif.Ali on 10/07/2024
 * @project TestKitDataService
 */
public class Person implements Serializable {
    private Long id;
    private String name;

    public Person() {
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
