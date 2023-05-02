package com.shivam.Client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.shivam.binding.Book;

import ch.qos.logback.core.net.server.Client;

@Service
public class BookClient {
	
		public void invokeSaveBook() {
			
			Book book = new Book();
			book.setBookName("Angular");
			book.setBookPrice(450.00);
			
			String apiUrl = "http://localhost:8085/book/";
			
			WebClient client = WebClient.create();
			
			String resp = client.post()// HTTP POST Request
								.uri(apiUrl)// End point URL
								.bodyValue(book)// passing object in post request
								.retrieve()// retrieve HTTP response Body

								.bodyToMono(String.class)// Bind Response to string var
								.block();// Make it as Sync Client	
			
			System.out.println(resp);
	}

		public void invokeGetBooks() {
			String apiUrl = "http://localhost:8085/books/";
			WebClient client = WebClient.create();
			
			/* //webclient instantiation
			
			String block = client.get() // GET Request
				.uri(apiUrl) // End point url
				.retrieve() // Retrieve Response body
				.bodyToMono(String.class)//bind Response data
				.block();//make it sync */
			
		Book[] responseData =	client.get()
					.uri(apiUrl)
					.retrieve()
					.bodyToMono(Book[].class).block(); // sync communication
			
	
		for(Book b : responseData) {
			System.out.println(b);
		}
		
		
			
			
		}
		
		public void invokeGetBooksAsync() {
			String apiUrl = "http://localhost:8085/books/";
			WebClient client = WebClient.create();
			
			client.get()
			.uri(apiUrl)
			.retrieve()
			.bodyToMono(Book[].class)
			.subscribe(BookClient::respHandler); // Async Communication
			
		System.out.println("************Request Sent************");
		}
		
		public static void respHandler(Book[] books) {
			for(Book b:books) {
				System.out.println(b);
			}
		}
}
