package com.shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shivam.binding.Book;

@Controller
public class BookController {
	
	@GetMapping("/")
	public String displayForm(Model model) {
		
		Book bookObj = new Book();
		model.addAttribute("book", bookObj);
		return "index";
	}
	
	@PostMapping("/book")
	public String saveBook(Book book,Model model) {
		
		System.out.println(book);
		
		model.addAttribute("msg", "Book Saved Successfully..");
		
		return "success";
	}
}
