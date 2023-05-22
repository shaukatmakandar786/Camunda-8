package com.example.jsonread1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.EnableZeebeClient;

@SpringBootApplication
@EnableZeebeClient
public class JsonRead1Application {

	public static void main(String[] args) {
		SpringApplication.run(JsonRead1Application.class, args);
	}

}
