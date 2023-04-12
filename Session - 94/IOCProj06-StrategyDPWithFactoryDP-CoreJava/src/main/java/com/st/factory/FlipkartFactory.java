//FlipkartFactory.java
package com.st.factory;

import com.st.comp.BlueDart;
import com.st.comp.Courier;
import com.st.comp.DTDC;
import com.st.comp.Flipkart;

public class FlipkartFactory {

	 //static factory method supporting Factory pattern
	public static   Flipkart  createFlipkart(String courierType) {
		    //create target class object
		    Flipkart fpkt=new Flipkart();
		    Courier courier=null;
		    //create Dependent class object based on given courier type
		    if(courierType.equalsIgnoreCase("dtdc"))
		    	courier=new DTDC();
		    else if(courierType.equalsIgnoreCase("bDart"))
		    	courier=new BlueDart();
		    else
		    	  throw new IllegalArgumentException("Invalid courier type");
		    //set  Dependent class object to target class obj
		       fpkt.setCourier(courier);
	       return fpkt;
     }
	
	
}
