//Test.java
package com.st.comp;

public class Test {
	private int a=10;
	private String b="Hello";
	
	public Test() {
		System.out.println("Test:: 0-param constructor");
	}
	
	//alt+shift+s,s
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	
	
}
