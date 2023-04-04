package com.shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class FirstController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Welcome to Spring Boot");
		mav.setViewName("welcome");
		return mav;
	}
	
	@GetMapping("/greet")
	public ModelAndView getgreetMsg() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msgs","Good Mornings");
		mav.setViewName("greet");
		return mav;
	}
	
}
