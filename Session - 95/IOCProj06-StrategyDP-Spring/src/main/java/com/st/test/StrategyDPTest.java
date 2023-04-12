//StrategyDPTest.java
package com.st.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.st.comp.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create IOC container
		 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/st/cfgs/applicationContext.xml");
		 //get Target class object
		 Flipkart fpkt=factory.getBean("fpkt",Flipkart.class);
		 //invoke the b.method
		 String resultMsg=fpkt.shopping(new String[] {"Kurta","Jeans","glasses"},
				                                                new float[] {5679.60f,5557.55f,4545.77f} );
		 
		 System.out.println(resultMsg);
		 
		 
	}//main
}//class
