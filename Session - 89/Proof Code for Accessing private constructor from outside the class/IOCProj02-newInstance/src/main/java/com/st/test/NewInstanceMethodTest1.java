//NewInstanceMethodTest1.java
package com.st.test;

import java.lang.reflect.Constructor;

public class NewInstanceMethodTest1 {
	public static void main(String[] args) throws Exception{
		
		// Load classes
		Class c1 = Class.forName(args[0]);
		
		// get All constructor of the Loaded class
		Constructor cons[] = c1.getDeclaredConstructors();
		// Dynamic object using 0 param Constructor
		cons[0].setAccessible(true);// gives access to private constructor
		Object obj = cons[0].newInstance();
		
		System.out.println(obj);
		
		System.out.println(".............");
		// Dynamic object using 0 param Constructor
		cons[1].setAccessible(true);// gives access to private constructor
		Object obj2 = cons[1].newInstance(100,"India");
				
			System.out.println(obj2);
				
				
		
		
	}
}
