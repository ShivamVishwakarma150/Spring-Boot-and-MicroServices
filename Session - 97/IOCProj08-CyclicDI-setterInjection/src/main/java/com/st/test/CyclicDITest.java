//CyclicDITest.java
package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.st.beans.A;

public class CyclicDITest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		
		reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
		
		//get Spring bean calss obj
		A  oa=factory.getBean("a1",A.class);
		System.out.println(oa);

	}

}
