package com.shivam.service;

import java.util.List;

import com.shivam.entity.Book;

public interface BookService {
		
	public String upsertBook(Book book);
	
	public List<Book> getAllBooks();
	
//	public String updateBook(Book book);
	
	public String deleteBook(Integer bookId);
	
}
