package com.shivam.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to HDFC bank";
	}
	
	@GetMapping("/transfer")
	public String transfer() {
		return "Funds Transfer Initiated!!";
		
	}
	@GetMapping("/balance")
	public String checkBalance() {
		return "Your Account Balance :: 10,000 INR";
		
	}
	@GetMapping("/about")
	public String aboutUS() {
		return "HDFC Bank Managing by Me";
		
	}
	
}
