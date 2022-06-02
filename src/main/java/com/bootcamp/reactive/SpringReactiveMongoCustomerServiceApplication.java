package com.bootcamp.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringReactiveMongoCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveMongoCustomerServiceApplication.class, args);
	}

}
