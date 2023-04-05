package com.shivam.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shivam.binding.Product;

@Controller
public class ProductController {
	
	@GetMapping("/")
	public String getProductForm(Model model) {
		Product productObj = new Product();
		
		model.addAttribute("product", productObj);
		
		return "index";
	}
	
	@PostMapping("/product")
	public String handleFormSubmit(Product product,Model model) {
		System.out.println(product);
		
		model.addAttribute("msg", "Prodcut saved Successfully");
		
		return "success";
	}
}
