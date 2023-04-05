package com.shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WishController {
	
	@GetMapping("/wish")
	@ResponseBody
	public String getWishMsg() {
		String msg = "<h1>All the best!!<h1>";
		
		return msg;
	}
}
