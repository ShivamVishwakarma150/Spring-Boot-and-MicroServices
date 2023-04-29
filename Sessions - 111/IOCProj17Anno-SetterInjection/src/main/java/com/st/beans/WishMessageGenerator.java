//WishMessageGenerator.java
package com.st.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


public class WishMessageGenerator {
	//HAS-A property (supporting composition)
	@Autowired
	private  Date  date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator : 0-param contructor ");
	}
	
	
	

	//B.method
	public  String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage():: date="+date);
		//get current hour of the day
		@SuppressWarnings("deprecation")
		int hour=date.getHours(); // 24 hours format (0 to 23)
		//generate wish messsage
		 if(hour<12)
			 return "Good Morning::"+user;
		 else if(hour<16)
			 return "Good AfterNoon::"+user;
		 else if(hour<20)
			 return "Good Evening::"+user;
		 else
			 return "Good Night::"+user;
	}//method
}//class
