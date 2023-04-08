package com.shivam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.binding.Product;

@RestController
public class ProductRestController {
	
	@GetMapping(value="/product",produces= {"application/xml","application/json"})
	public ResponseEntity<Product> getProduct(){
			
		Product productObj =new Product();
		productObj.setPid(101);
		productObj.setPname("Keyboard");
		productObj.setPrice(700.00);
		
		return new ResponseEntity<>(productObj,HttpStatus.OK);
	}
}
