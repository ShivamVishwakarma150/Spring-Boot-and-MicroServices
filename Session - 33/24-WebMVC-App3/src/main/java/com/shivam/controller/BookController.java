package com.shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shivam.bindings.Book;

@Controller
public class BookController {
	
	@GetMapping("/book")
	public String getBookData(Model model) {
		
		// setting data to binding object
		Book bookObj = new Book(101,"Spring",450.00);
		
		//adding data to model object to send to ui
		model.addAttribute("book",bookObj);
		
		// return view name
		return "book";
	}
}
