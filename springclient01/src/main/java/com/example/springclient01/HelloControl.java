package com.example.springclient01;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {


    @GetMapping("/client")
    public String client() {
       return "name";
    }
}
