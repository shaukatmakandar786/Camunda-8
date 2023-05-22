package com.shaukat;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class RestApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiExampleApplication.class, args);
	}

}
