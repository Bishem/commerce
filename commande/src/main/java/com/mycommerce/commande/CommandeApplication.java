package com.mycommerce.commande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CommandeApplication {

	public static void main(final String[] args) {

		SpringApplication.run(CommandeApplication.class, args);
	}
}
