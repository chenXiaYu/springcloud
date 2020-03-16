package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/getUser/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable(name = "id") String id){
        User user = restTemplate.getForObject("http://localhost:8081/getUser/"+id,User.class);
        return  user;
    }
}
