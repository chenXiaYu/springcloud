package com.example.demo;

import com.example.demo.bean.User;
import org.springframework.stereotype.Component;

@Component
public class MyFallback implements  UserClient {

    @Override
    public User get(String id) {
        User user = new User();
        user.setId(id);
        user.setName("error feign__");

        return  user;
    }
}
