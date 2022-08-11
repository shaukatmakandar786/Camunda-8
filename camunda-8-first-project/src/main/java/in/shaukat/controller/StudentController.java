package in.shaukat.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceResult;

@RestController
public class StudentController {
	
	@Autowired
	ZeebeClient client;
	
	@GetMapping("/marks/{marks}")
	public String calGrade(@PathVariable Integer marks) {
		
		Map<String,Object> map=new HashMap<>();
		if(marks>=75) {
			map.put("key", "Distinction");
			System.out.println(map);
		}
		else if(marks>=60 && marks<=75) {
			map.put("key", "FirstClass");
			System.out.println(map);
		}
		else if(marks>=35) {
			map.put("key", "PassClass");
			System.out.println(map);
		}
		
		ProcessInstanceResult CreateProcessInstance = client.newCreateInstanceCommand().
				bpmnProcessId("GradeProcess").latestVersion().variables(map).
				withResult().send().join();
		
		return "";
	}

}
