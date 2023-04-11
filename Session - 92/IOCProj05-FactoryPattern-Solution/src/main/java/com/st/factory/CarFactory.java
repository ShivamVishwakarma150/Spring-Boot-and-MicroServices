//CarFactory.java
package com.st.factory;

import com.st.comp.BudgetCar;
import com.st.comp.Car;
import com.st.comp.LuxoryCar;
import com.st.comp.SportsCar;

public class CarFactory {
	
	//Factory having  factory pattern logic  (Logic to create and return one of several related classes objects) 
	public static  Car  createCar(String type, String regNo) {
		   if(type.equalsIgnoreCase("sports"))
			   return new SportsCar(regNo);
		   else if(type.equalsIgnoreCase("budget"))
			   return new BudgetCar(regNo);
		   else if(type.equalsIgnoreCase("luxory"))
			   return new LuxoryCar(regNo);
		   else
			   throw new IllegalArgumentException("Invalid car Type");
	}

}
