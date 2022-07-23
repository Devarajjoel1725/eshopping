package com.productmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroservice.class, args);
	}

}
