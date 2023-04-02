package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.shivam.entity.User;
import com.shivam.repository.UserRepository;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =	SpringApplication.run(Application.class, args);
		
		// giving the implementation for UserRepository interface
		UserRepository repository = context.getBean(UserRepository.class);
	
		/*User u5 = new User(105,"Ganesh","Male",33,"India");
		User u6 = new User(106,"Suresh","Male",34,"Germany");
		User u7 = new User(107,"Mahesh","Male",35,"Mexico");
		User u8 = new User(108,"Buttler","Male",36,"Australia");
		User u9 = new User(105,"Cathy","Fe-Male",29,"US");
		User u10 = new User(109,"Naresh","Male",28,"Canada");
		
		repository.saveAll(Arrays.asList(u5,u6,u7,u8,u9,u10)); */
		
		
		//List<User> users= repository.findAll();
		
		//List<User> users = repository.findAll(Sort.by("age").ascending());
		
		/*List<User> users = repository.findAll(Sort.by("username","age").descending());
		
		users.forEach(user->{
			System.out.println(user);
		});
		*/
		
		/*
		// we request only first page records
		// 0 represents page index means 1st page
		// 3 represents page content size max 3 contents are there
		PageRequest pageRequest =  PageRequest.of(1, 3);
		
		Page<User> pageData = repository.findAll(pageRequest);		
		
		List<User> users = pageData.getContent();
		
		users.forEach(user->{
			System.out.println(user);
		});
		*/
		/*
		int pageIndex=0;
		int pageSize=5;
		
		PageRequest pageRequest =  PageRequest.of(pageIndex, pageSize);
		
		Page<User> pageData = repository.findAll(pageRequest);		
		
		int totalPages = pageData.getTotalPages();
		System.out.println("Total Pages :: "+totalPages);
		
		List<User> users = pageData.getContent();
		
		users.forEach(user->{
			System.out.println(user);
		});
		*/
		
		// QBE
		
		User entity = new User();
		
		entity.setCountry("India");
		entity.setAge(25);
		
		Example<User> example = Example.of(entity);
		
		List<User> users = repository.findAll(example);
		
		users.forEach(user->{
			System.out.println(user);
		});
		
		
		
	}

}
