package in.shivam.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Engine {
	public Engine() {
		System.out.println("Engine() constructor Called.....");
	}
	
	@PostConstruct
	public void init() throws Exception {
		System.out.println("Start Engine...");
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Stop Engine....");
	}
}
