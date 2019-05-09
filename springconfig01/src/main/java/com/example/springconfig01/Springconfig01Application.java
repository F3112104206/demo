package com.example.springconfig01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Springconfig01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springconfig01Application.class, args);
    }

}
