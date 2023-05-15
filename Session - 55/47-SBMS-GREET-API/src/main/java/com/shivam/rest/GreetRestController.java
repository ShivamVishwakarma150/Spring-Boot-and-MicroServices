package com.shivam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.client.WelcomeApiClient;

@RestController
public class GreetRestController {
	
	@Autowired
	private WelcomeApiClient welcomeClient;
	
	@GetMapping("/greet")
	public String getgreetMst() {
		String greetMsg = "Good Morning, ";
		
		String welcomeMsg = welcomeClient.invokeWelcomeApi();
		
		return greetMsg + welcomeMsg;
	}
}
