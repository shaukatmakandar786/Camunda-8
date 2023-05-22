package com.shaukat.controller;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    ZeebeClient zeebeClient;

    @PostMapping("/start")
    public String startProcess(){

        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("RestAPIExampleProcess001")
                .latestVersion()
                .send()
                .join();
        return "process started successfully";
    }

    @GetMapping("/API1")
    public Map<String, Object> API1() {

        Map<String, Object> map1 = new HashMap<>();
        map1.put("age", 21);
        map1.put("name", "Shaukat");
        System.out.println("api 1");
        return map1;

    }

    @GetMapping("/API2")
    public Map<String, Object> API2() {
        Map<String, Object> map2 = new HashMap<>();
        map2.put("City", "Pune");
        map2.put("state", "Maharashtra");
        System.out.println("api 2");
        return map2;

    }

    @GetMapping("/API3")
    public Map<String, Object> API3() {
        Map<String, Object> map3 = new HashMap<>();
        map3.put("phonenumber", "7768844567");
        System.out.println("api 3");
        return map3;

    }
}
