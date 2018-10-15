package com.commerce.commande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CommandeApplication {

    public static void main(final String[] args) {

        SpringApplication.run(CommandeApplication.class, args);
    }
}
