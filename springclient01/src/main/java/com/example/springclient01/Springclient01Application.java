package com.example.springclient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Springclient01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springclient01Application.class, args);
    }

}
