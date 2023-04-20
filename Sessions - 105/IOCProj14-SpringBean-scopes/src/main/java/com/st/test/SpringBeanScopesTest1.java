package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.st.ston.Printer;

public class SpringBeanScopesTest1 {

	public static void main(String[] args) {
   //create IOC container
		 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
		 //get Spring bean class obj
		 Printer p1=factory.getBean("p1",Printer.class);
		 Printer p2=factory.getBean("p1",Printer.class);
		 System.out.println(p1.hashCode()+"  "+p2.hashCode());
		 System.out.println("====================");
		 
		 

	}//main
}//class
