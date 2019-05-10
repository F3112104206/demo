package com.example.springclient03;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="eureka01",fallback = TestFeignBack.class)
public interface TestFeign {


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String test();
}
