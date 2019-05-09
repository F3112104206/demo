package com.example.springcilent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String ip;

    @GetMapping("/client")
    public String client() {
        String services = "Services: " + discoveryClient.getServices()+" ip :"+ip;

        System.out.println(services);
        return services;
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instance = discoveryClient.getInstances("eureka-client01");
        System.out.printf("**********");
        return "Hello World";
    }
}
