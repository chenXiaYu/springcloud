package com.example.demo;


import com.example.demo.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

   @Autowired
   private UserClient userClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getUserError")
    public User getUser(@PathVariable(name = "id") String id){
        return  userClient.getUser(id);
    }
//
//    @RequestMapping(value = "/url",method = RequestMethod.GET)
//    public String getString(){
//        ServiceInstance choose = loadBalancerClient.choose("provider");
//        String url = choose.getHost()+choose.getInstanceId();
//        System.out.println(url);
//        return url;
//    }

    public User getUserError(String id){
        User user = new User();
        user.setId(id);
        user.setName("error ...");

        return  user;
    }
}
