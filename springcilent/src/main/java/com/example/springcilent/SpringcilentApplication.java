package com.example.springcilent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.mapper.*")
@ComponentScan(basePackages = "com.example.*")
public class SpringcilentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcilentApplication.class, args);
    }

}
