package com.shivam.binding;



import lombok.Data;

@Data
public class Book {
	
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Author author;
}
