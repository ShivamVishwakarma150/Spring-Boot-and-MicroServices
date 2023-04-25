//StrategyDPTest.java
package com.st.test;


import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.st.comp.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		 FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/st/cfgs/applicationContext.xml");
		 //get Target class obj
		 Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
		 //invoke the b.method
		 String resultMsg=fpkt.shopping(new String[] {"shirt","trouser","glasses"},
				                                                new float[] {5679.60f,5557.55f,4545.77f} );
		 System.out.println(resultMsg);
		 
		 //close container
		 ctx.close();
		 
	}//main
}//class
