package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.st.beans.Customer;
import com.st.beans.Employee1;
import com.st.beans.Student;

public class ConstructorVsSetterInjectionTest {

	public static void main(String[] args) {
		 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		  XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		  reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
		  //get Spring bean class obj
		  Employee1 emp1=factory.getBean("emp1",Employee1.class);
		  System.out.println(emp1);
		  System.out.println("====================");
		  Student  st1=factory.getBean("stud1",Student.class);
		  System.out.println(st1);
		  System.out.println("====================");
		 Customer  cust1=factory.getBean("cust1",Customer.class);
		  System.out.println(cust1);
		
		
		  
		  
	}

}
