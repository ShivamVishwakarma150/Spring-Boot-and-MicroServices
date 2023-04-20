package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


import com.st.beans.WishMessageGenerator;

public class SpringBeanScopesTest {

	public static void main(String[] args) {
   //create IOC container
		 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
		//get Target spring bean class object
		WishMessageGenerator generator1=factory.getBean("wmg",WishMessageGenerator.class);
		WishMessageGenerator generator2=factory.getBean("wmg",WishMessageGenerator.class);
		
	
		System.out.println("hashcodes=="+generator1.hashCode()+"   "+generator2.hashCode());
		System.out.println("generator1==generator2?"+(generator1==generator2));
		
		 System.out.println("=====================================");
		 

	}//main
}//class
