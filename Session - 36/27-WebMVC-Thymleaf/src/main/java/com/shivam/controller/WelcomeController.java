package com.shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String getWelcomeMsg(Model model) {
		
		model.addAttribute("msg","Welcome to India");
		
		return "index";
	}
}
