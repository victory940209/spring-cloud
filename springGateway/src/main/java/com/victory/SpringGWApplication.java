package com.victory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SpringGWApplication {

	public static void main(String[] args) {
		SpringApplication api = new SpringApplication(SpringGWApplication.class);
		api.addListeners(new ApplicationPidFileWriter());
		api.run(args);
	}

}
