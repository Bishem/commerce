package com.commerce.produit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProduitApplication {

	public static void main(final String[] args) {

		SpringApplication.run(ProduitApplication.class, args);
	}
}
