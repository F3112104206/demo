package com.example.springconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringconfigApplication.class, args);
    }

}
