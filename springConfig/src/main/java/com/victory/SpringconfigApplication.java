package com.victory;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringconfigApplication.class, args);
		
		
	}

	
	
}
