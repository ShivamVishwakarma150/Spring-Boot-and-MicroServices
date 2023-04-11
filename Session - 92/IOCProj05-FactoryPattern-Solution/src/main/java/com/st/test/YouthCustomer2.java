//YouthCustomer2.java
package com.st.test;


import com.st.comp.Car;
import com.st.factory.CarFactory;

public class YouthCustomer2 {
	public static void main(String[] args) {
		//get Car obj using factory
		Car car=CarFactory.createCar("sports", "TS08 EN 6688");
		car.drive();
		System.out.println("================");
		
	}

}
