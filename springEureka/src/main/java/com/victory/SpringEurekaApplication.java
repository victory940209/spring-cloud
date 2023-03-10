package com.victory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaApplication {

	public static void main(String[] args) {
		SpringApplication api = new SpringApplication(SpringEurekaApplication.class);
		api.addListeners(new ApplicationPidFileWriter());
		api.run(args);
	}

}
