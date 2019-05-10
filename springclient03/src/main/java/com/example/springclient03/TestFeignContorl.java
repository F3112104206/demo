package com.example.springclient03;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignContorl {
        @Autowired
        private TestFeign testFeign;

        @GetMapping("/hh")
        public String testP(){
           return testFeign.test();
        }

        @HystrixCommand(fallbackMethod = "testBack")
        @GetMapping("/testh")
        public String testh(){
                return testFeign.test();
        }


        public String testBack(){
                return "testBack over";
        }


}
