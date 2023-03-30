package com.microservice.tuto.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceGatewayServerApplication.class, args);
	}

}
