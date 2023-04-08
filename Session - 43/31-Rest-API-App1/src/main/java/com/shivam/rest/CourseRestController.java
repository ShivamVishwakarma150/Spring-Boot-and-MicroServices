package com.shivam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {
	
	@GetMapping("/course")
	public ResponseEntity<String> getCourseFee(@RequestParam("cname") String cname, @RequestParam("tname") String tname) {
		
		String respBody = cname +" By "+tname+" Fee is 7000 INR";
		
		return new ResponseEntity<>(respBody,HttpStatus.OK) ;
	}
}
