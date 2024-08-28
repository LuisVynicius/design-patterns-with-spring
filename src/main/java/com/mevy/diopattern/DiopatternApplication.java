package com.mevy.diopattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition
public class DiopatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiopatternApplication.class, args);
	}

}
