//BusinessManCustomer3 .java
package com.st.test;


import com.st.comp.Car;
import com.st.factory.CarFactory;

public class BusinessManCustomer3 {
	public static void main(String[] args) {
		//get Car obj using factory
		Car car=CarFactory.createCar("luxory", "TS10 EN 5688");
		car.drive();
		System.out.println("================");
	}

}
