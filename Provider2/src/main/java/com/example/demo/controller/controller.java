package com.example.demo.controller;

import com.example.demo.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

@RestController
public class controller {

    @RequestMapping(path = "/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "myfallback")
    public User getUser(@PathVariable(name = "id") String id){
        User user = new User();
        user.setId(id);
        user.setName("chenxiayu");
        return  user;
    }


    public  User myfallback(String id){
        User user = new User();
        return  user;
    }

}
