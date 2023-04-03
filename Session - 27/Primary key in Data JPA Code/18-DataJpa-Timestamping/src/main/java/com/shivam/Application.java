package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.entity.Product;
import com.shivam.repo.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
	ProductRepository repository =	context.getBean(ProductRepository.class);
		Product p1 = new Product();
		
		p1.setPname("Ram");
		p1.setPrice(6000.00);
		
		repository.save(p1);
			
	}

}
