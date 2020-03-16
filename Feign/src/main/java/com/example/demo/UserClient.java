package com.example.demo;

import com.example.demo.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider",fallback = MyFallback.class)
public interface UserClient {
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    User getUser(@PathVariable(name = "id") String id);



}
