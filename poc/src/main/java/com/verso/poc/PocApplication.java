package com.verso.poc;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.function.Consumer;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}


	public static Consumer<HttpHeaders> consumer(HttpHeaders headers) {
		return httpHeaders -> httpHeaders.addAll(headers);
	}

	@Bean
	public WebMvcConfigurer webConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("v1/api/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

	@Bean
	public Module jsonNullableModule() {
		return new JsonNullableModule();
	}

}
