package com.shivam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSecurity {
	public AppSecurity() {
		System.out.println("AppSecurity :: Constructor");
	}
	@Bean
	public AppSecurity createInstance() {
		AppSecurity as = new AppSecurity();
		// custom logic to secure our functionality
		return as;
	}
}
