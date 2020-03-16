package com.example.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${profile}")
    private String value;

    @GetMapping("/get")
    public String getDate(){
        return  value;
    }
}
