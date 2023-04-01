package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.entity.User;
import com.shivam.repository.UserRepository;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =	SpringApplication.run(Application.class, args);
		
		// giving the implementation for UserRepository interface
		UserRepository repository = context.getBean(UserRepository.class);
		
		User u1 = new User(101,"Ramesh","Male",25,"India");
		
//		repository.save(u1);
		
		User u2 = new User(102,"Raju","Male",26,"India");
		User u3 = new User(103,"johny","Male",30,"India");
		User u4 = new User(104,"Rakesh","Male",32,"US");
		
		repository.saveAll(Arrays.asList(u2,u3,u4));
		
		
		// Retrive Record based on primary key
		// Here optional means record may available or may not be available
		/* Optional<User> findById =  repository.findById(103);
		if(findById.isPresent()) {
			System.out.println(findById.get()); */
			
			// Retrive multiple record based on primary keys
			/* Iterable<User> allById =  repository.findAllById(Arrays.asList(101,102));
			
			allById.forEach(user ->{
				System.out.println(user);
			});
			*/
		
		/* Iterable<User> findAll = repository.findAll();
		
		findAll.forEach(user ->{
			System.out.println(user);
		}); */
		
		/*long count = repository.count();
		
		System.out.println("total Records in table :: "+count); */
		
		/*boolean existById = repository.existsById(102);
		System.out.println("Record Precence with id - 102 :: "+existById);*/
		
		//repository.deleteById(104);
		
//		repository.deleteAllById(Arrays.asList(102,103));	
			
			
			
		
	}

}
