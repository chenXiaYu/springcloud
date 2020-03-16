package com.example.demo;

import com.example.demo.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider2",fallback = MyFallback.class)
public interface UserClient {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    User get(@PathVariable(name = "id") String id);



}
