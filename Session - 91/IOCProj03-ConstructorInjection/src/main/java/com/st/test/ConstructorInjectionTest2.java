package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.st.beans.WishMessageGenerator;

public class ConstructorInjectionTest2 {
	
	
	public static void main(String[] args) {
		
		//create IOC container
				DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
				XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
				
				reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
				//get Target spring bean class object
				WishMessageGenerator  generator=factory.getBean("wmg",WishMessageGenerator.class);
				//invoke the b.method
				String result=generator.generateMessage("Rakesh");
				System.out.println("Wish Message is ::"+result); 
		
		
	
	}//main
}//class
