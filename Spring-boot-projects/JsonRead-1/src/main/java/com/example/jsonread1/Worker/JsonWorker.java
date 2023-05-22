package com.example.jsonread1.Worker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;

@SpringBootApplication
public class JsonWorker {

	@Autowired
	ZeebeClient zeebeClient;
	
	RestTemplate restTemplate=new RestTemplate();
	
	@ZeebeWorker(name="JsonFileRead1",type="employee-info")
	public void json1(final JobClient client,final ActivatedJob job ) {
		
		String url= "http://localhost:1802/json1";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url ,String.class);
	
		String json1=response.getBody();
		System.out.println(json1);
		
		
		zeebeClient.newCompleteCommand(job.getKey()).variables(json1).send().join();

		System.out.println("json file 1 completed");
		
	}
	
	@ZeebeWorker(name="JsonFileRead2",type="employee-addr")
	public void json2(final JobClient client,final ActivatedJob job ) {
		
		String url= "http://localhost:1802/json2";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url ,String.class);
	
		String json2=response.getBody();
		System.out.println(json2);
		
		
		zeebeClient.newCompleteCommand(job.getKey()).variables(json2).send().join();

		System.out.println("json file 2 completed");
		
	}

	@ZeebeWorker(name="final",type="merge-data")
	public void json4(final JobClient client,final ActivatedJob job ) {
		
		Map<String, Object> finalmap=new HashMap<>();
		finalmap = job.getVariablesAsMap();
		System.out.println(finalmap);
		zeebeClient.newCompleteCommand(job.getKey()).variables(finalmap).send().join();
	}
	
	
}
