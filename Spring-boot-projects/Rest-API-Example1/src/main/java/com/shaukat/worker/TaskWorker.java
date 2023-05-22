package com.shaukat.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TaskWorker {

    @Autowired
    ZeebeClient zeebeClient;

    RestTemplate restTemplate = new RestTemplate();

    @ZeebeWorker(name = "API1", type = "API1")
    public void Api1(JobClient jobClient, ActivatedJob activatedJob) {

        String url = "http://localhost:9093/API1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();

        zeebeClient.newCompleteCommand(activatedJob.getKey()).variables(body).send().join();
        System.out.println("Api1 is completed...!");
    }

    @ZeebeWorker(name = "API2", type = "API2")
    public void Api2(JobClient jobClient, ActivatedJob activatedJob) {

        String url = "http://localhost:9093/API2";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();

        zeebeClient.newCompleteCommand(activatedJob.getKey()).variables(body).send().join();
        System.out.println("Api2 is completed...!");
    }

    @ZeebeWorker(name = "API3", type = "API3")
    public void Api3(JobClient jobClient, ActivatedJob activatedJob) {

        String url = "http://localhost:9093/API3";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();

        zeebeClient.newCompleteCommand(activatedJob.getKey()).variables(body).send().join();
        System.out.println("Api2 is completed...!");
    }

    @ZeebeWorker(type = "final", name = "FinalTask")
    public void finalMethod(final JobClient client, final ActivatedJob job) throws Exception {

        Map<String, Object> finalMap = new HashMap<>();

        finalMap = job.getVariablesAsMap();

        System.out.println(finalMap);
        zeebeClient.newCompleteCommand(job.getKey()).variables(finalMap).send().join();
    }
}
