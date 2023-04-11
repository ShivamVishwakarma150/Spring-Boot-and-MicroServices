//ProfessionalCustomer1.java
package com.st.test;


import com.st.comp.Car;
import com.st.factory.CarFactory;

public class ProfessionalCustomer1 {
	public static void main(String[] args) {
		//get Car obj using factory
			Car car=CarFactory.createCar("budget", "TS09 EN 5688");
			car.drive();
			System.out.println("================");
	}

}
