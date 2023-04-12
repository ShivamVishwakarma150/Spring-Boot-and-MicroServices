//FlipkartFactory.java
package com.st.factory;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.st.comp.Courier;
import com.st.comp.Flipkart;

public class FlipkartFactory {
     private static Properties props;
     static {
    	 System.out.println("FlipkartFactory.static block");
   try(
		   //Load Properties file
    		 FileInputStream fis=new FileInputStream("src/main/java/com/st/commons/info.properties")
	  ){
    		 //load properties file content to java.util.Properties class object
    		 props=new Properties();
    		 props.load(fis);
    	 }//try
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     
	 //static factory method supporting Factory pattern
	public static   Flipkart  createFlipkart()throws Exception {
		    //create target class obj
		    Flipkart fpkt=new Flipkart();
		    
		    // Load Dependent class 
		     Class c=Class.forName(props.getProperty("dependent.comp"));
		     //create object using reflection object
		      Constructor cons[]=c.getDeclaredConstructors();
		      //create object
		      Courier courier=(Courier) cons[0].newInstance();
		        //set  Dependent class object to target class obj
		       fpkt.setCourier(courier);
	       return fpkt;
     }
	
	
}
