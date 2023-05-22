package com.example.jsonread.controller;

import io.camunda.zeebe.client.ZeebeClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class JsonController {

    @Autowired
    ZeebeClient zeebeclient;

    @PostMapping("/start")
    public String start() {

        zeebeclient.newCreateInstanceCommand().bpmnProcessId("ReadFileExampleProcess").latestVersion().send().join();
        return "started successfully...!";
    }

    @GetMapping("/json1")
    public JSONObject json1() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        Object obj = jsonparser.parse(new FileReader("C:\\Users\\STS173\\Desktop\\Camunda8 Training\\camunda-zeebe\\camunda-zeebe\\JsonRead\\src\\main\\resources\\JsonFiles\\Employee.json"));
        JSONObject jsobject = (JSONObject) obj;

        System.out.println(jsobject);

        return jsobject;

    }

    @GetMapping("/json2")
    public String json2() throws FileNotFoundException, IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        Object obj = jsonparser.parse(new FileReader("C:\\Users\\STS173\\Desktop\\Camunda8 Training\\camunda-zeebe\\camunda-zeebe\\JsonRead\\src\\main\\resources\\JsonFiles\\Address.json"));
        JSONObject jsobject = (JSONObject) obj;

        System.out.println(jsobject);

        return jsobject.toString();

    }

}
