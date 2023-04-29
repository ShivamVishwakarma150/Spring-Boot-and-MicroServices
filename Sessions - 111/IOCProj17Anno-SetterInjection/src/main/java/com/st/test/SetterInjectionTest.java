package com.st.test;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.st.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/st/cfgs/applicationContext.xml");
				//get Bean spring bean class obj
				WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
				
				
		//invoke the b.method
		String result=generator.generateMessage("rajesh");
		System.out.println("Wish Message is ::"+result);
		//close the IOC container
		ctx.close();

	}//main
}//class
