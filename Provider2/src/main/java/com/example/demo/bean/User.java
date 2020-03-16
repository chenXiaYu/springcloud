package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
