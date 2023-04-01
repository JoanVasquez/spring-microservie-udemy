package com.microservice.tuto.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringbootConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigServiceApplication.class, args);
	}

}
