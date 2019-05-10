package com.example.springclient01;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {


    @GetMapping("/user")
    public String client() {
       return "nameuuuuuu";
    }


    @GetMapping("/user2")
    public String apiTest() {
        return "HelloControl>>>ds HelloControl sdf api";
    }


}
