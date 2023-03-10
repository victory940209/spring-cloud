package com.victory.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {

		return new OpenAPI().info(new Info()
				.version("v1.0.0")
				.title("aas001tile")
				.description("Description 입니다.")
				.summary("summary 입니다."));
	}
}
