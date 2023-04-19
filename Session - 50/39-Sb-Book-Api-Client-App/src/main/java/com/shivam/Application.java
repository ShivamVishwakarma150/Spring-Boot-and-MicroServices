package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.client.BookClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		BookClient bean = run.getBean(BookClient.class);
//		bean.invokeBookTicket();
//		bean.invokeGetBooksOld();
		bean.invokeGetBooksNew();
	}

}
