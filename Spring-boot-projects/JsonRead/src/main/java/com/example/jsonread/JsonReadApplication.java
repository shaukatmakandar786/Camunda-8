package com.example.jsonread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.EnableZeebeClient;

@SpringBootApplication
@EnableZeebeClient
public class JsonReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonReadApplication.class, args);
	}

}
