package in.shaukat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;

@SpringBootApplication
@EnableZeebeClient
public class Camunda8FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Camunda8FirstProjectApplication.class, args);
	}
	@ZeebeWorker(type="service1", name="service1")
	public void addition(final JobClient client,final ActivatedJob job)throws Exception {
		
		Map<String, Object> map = job.getVariablesAsMap();
		
		Integer a=(Integer)map.get("a");
		Integer b=(Integer)map.get("b");
		Integer c=(Integer)map.get("c");	
		
		System.out.println(map);
		int ans=a+b+c;
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("ans", ans);
		
		client.newCompleteCommand(job.getKey()).variables(map1).send().join();
		
		
	}
	
	@ZeebeWorker(type="service2", name="service2")
	public void squre(final JobClient client,final ActivatedJob job)throws Exception {
		
		Map<String, Object> map=job.getVariablesAsMap();
		
		Integer sum=(Integer)map.get("ans");
	
		Integer multiplication=sum*sum;
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("mul", multiplication);
		
		System.out.println(multiplication);
		System.out.println(map);
		
		client.newCompleteCommand(job.getKey()).variables(map1).send().join();
		
		
	}

}
