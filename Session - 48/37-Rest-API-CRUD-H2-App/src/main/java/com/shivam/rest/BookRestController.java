package com.shivam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.entity.Book;
import com.shivam.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookService service;
	
	
	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody Book book){
			
		String msg = service.upsertBook(book);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks = service.getAllBooks();
		
		return new ResponseEntity<>(allBooks,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		String msg = service.upsertBook(book);
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/book/{bookId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookID){
		String msg = service.deleteBook(bookID);
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
