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
		
		/*List<User> findByCountry = repository.findByCountry("India");
			
		findByCountry.forEach(user->{
			System.out.println(user);
		}); */
		
		
		
		/*List<User> findByAge = repository.findByAge(30);
		
		findByAge.forEach(user->{
			System.out.println(user);
		}); */
		
		/*List<User> list = repository.findByAgeGreaterThanEqual(30);
		
	list.forEach(user->{
		System.out.println(user);
	});	*/
		
		
		/*List<User> list = repository.findByCountryIn(Arrays.asList("India","US"));
		
		list.forEach(user->{
			System.out.println(user);
		});  */
		
		
		/*List<User> list= repository.findByCountryAndAge("India", 30);
		list.forEach(user->{
			System.out.println(user);
		}); */
		
		
		/*List<User> list = repository.findByCountryAndGender("India", "Male");
		
		list.forEach(user->{
			System.out.println(user);
		}); */
		
		
		List<User> list = repository.findByCountryAndAgeAndGender("India",25, "Male");
		
		list.forEach(user->{
			System.out.println(user);
		});
			
		
	}

}
