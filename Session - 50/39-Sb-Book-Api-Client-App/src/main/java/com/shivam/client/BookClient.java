package com.shivam.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shivam.binding.Book;

@Service
public class BookClient {
	
	public void invokeBookTicket() {
		
		String apiUrl = "http://localhost:8085/book/";
		
		Book book = new Book();
		book.setBookName("Java");
		book.setBookPrice(340.0);
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> postForEntity = rt.postForEntity(apiUrl, book,String.class);// String.class represents response type
		
		System.out.println(postForEntity.getBody());
	}
	
	public void invokeGetBooksOld() {
		String apiUrl = "http://localhost:8085/books/";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity(apiUrl,String.class);
		String body = forEntity.getBody();
		System.out.println(body);
		
	}
	
	public void invokeGetBooksNew() {
		String apiUrl = "http://localhost:8085/books/";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Book[]> forEntity = rt.getForEntity(apiUrl,Book[].class);
		Book[] body = forEntity.getBody();
		
		for(Book book:body) {
			System.out.println(book);
		}
		
		
	}
	
}
