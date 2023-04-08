package com.shivam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
		
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMsg(@RequestParam("name") String name){
		
		String resPayload = name+" Welcome to India";
		
		return new ResponseEntity<>(resPayload,HttpStatus.OK);
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String resPayload ="Good Morning..!!";
		
		return resPayload;
	}
}
