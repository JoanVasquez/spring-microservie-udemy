package com.microservice.tuto.app.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootOauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOauthServiceApplication.class, args);
	}

}
