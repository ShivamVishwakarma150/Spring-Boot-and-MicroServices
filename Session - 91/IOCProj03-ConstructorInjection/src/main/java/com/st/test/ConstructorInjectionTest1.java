package com.st.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.st.beans.WishMessageGenerator;

public class ConstructorInjectionTest1 {
	
	
	public static void main(String[] args) {
		// Locate and hold spring bean cfgs file name and location
		FileSystemResource res = new FileSystemResource("src/main/java/com/st/cfgs/applicationContext.xml");
		
		//create IOC Container (BeanFactory container)
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get Target spring bean class object
		WishMessageGenerator  generator=factory.getBean("wmg",WishMessageGenerator.class);
		//invoke the b.method
		String result=generator.generateMessage("Rajesh");
		System.out.println("Wish Message is ::"+result); 

		
		
	
	}//main
}//class
