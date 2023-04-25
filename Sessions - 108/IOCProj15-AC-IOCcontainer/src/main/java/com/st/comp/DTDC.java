//DTDC.java (Dependent class1)
package com.st.comp;

public final class DTDC implements Courier {
  
	public DTDC() {
		System.out.println("DTDC:: 0-param consturctor");
	}
	
	@Override
	public String deliver(int oid) {
	    return oid+" order id order  is delivered by DTDC";
	}

}
