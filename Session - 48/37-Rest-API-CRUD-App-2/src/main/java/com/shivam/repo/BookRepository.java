package com.shivam.repo;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable> {
	
}
