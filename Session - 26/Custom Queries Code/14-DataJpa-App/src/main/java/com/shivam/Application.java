package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.entity.User;
import com.shivam.repository.UserRepository;

import java.util.List;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =	SpringApplication.run(Application.class, args);
		
		// giving the implementation for UserRepository interface
		UserRepository repository = context.getBean(UserRepository.class);
		
		List<User> users = repository.getAllUsersSql();
		
		users.forEach(user->{
			System.out.println(user);
		});
		
		System.out.println("###########################################################################");
		
		List<User> users1 = repository.getAllUsersHql();
		
		users1.forEach(user->{
			System.out.println(user);
		});
		
System.out.println("###########################################################################");
		
		List<User> users2 = repository.getAllUsersByCountry("India");
		
		users2.forEach(user->{
			System.out.println(user);
		});
		
System.out.println("###########################################################################");
		
		List<User> users3 = repository.getAllUsersByCountryAndAge("India",25);
		
		users3.forEach(user->{
			System.out.println(user);
		});
		
	}

}
