package com.shaukat;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class RestApiExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiExample1Application.class, args);
	}

}
