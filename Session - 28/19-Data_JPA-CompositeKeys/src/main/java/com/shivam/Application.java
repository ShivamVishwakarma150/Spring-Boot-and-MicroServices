package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.service.AccountService;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		AccountService accountService = context.getBean(AccountService.class);
		//accountService.saveAccData();
		accountService.getDataUsingPK();
		
		context.close();

			
	}

}
