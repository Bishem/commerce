package com.commerce.expedition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ExpeditionApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExpeditionApplication.class, args);
    }
}
