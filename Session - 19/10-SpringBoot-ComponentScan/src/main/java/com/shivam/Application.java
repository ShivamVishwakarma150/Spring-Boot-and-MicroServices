package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.shivam.security.AppSecurity;

@SpringBootApplication
@ComponentScan(basePackages = { "com.shivam", "com.walmart" }) 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	

}
