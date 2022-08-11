package in.shaukat.worker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;

@SpringBootApplication
public class StudentWorker {

	final RestTemplate rest=new RestTemplate();
	
	@ZeebeWorker(type="Distinction", name="Distinction")
	public void distinction(final JobClient client,final ActivatedJob job)throws Exception {
		
		Map<String, Object> map=job.getVariablesAsMap();
		System.out.println("Distinction"+map);
		client.newCompleteCommand(job.getKey()).variables(map).send().join();
		
	}
	
	@ZeebeWorker(type="FirstClass", name="FirstClass")
	public void firstClass(final JobClient client,final ActivatedJob job)throws Exception {
		
		Map<String, Object> map=job.getVariablesAsMap();
		System.out.println("FirstClass"+map);
		client.newCompleteCommand(job.getKey()).variables(map).send().join();
		
	}
	
	@ZeebeWorker(type="PassClass", name="PassClass")
	public void passClass(final JobClient client,final ActivatedJob job)throws Exception {
		
		Map<String, Object> map=job.getVariablesAsMap();
		System.out.println("PassClass"+map);
		client.newCompleteCommand(job.getKey()).variables(map).send().join();
		
	}
}
