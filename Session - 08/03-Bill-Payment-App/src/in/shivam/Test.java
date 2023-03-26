package in.shivam;

import java.lang.reflect.Field;
public class Test {
	public static void main(String[] args) throws Exception {
		
		
//		CreditCardPayment
//		 ccd = new CreditCardPayment();
		
//		// field Injection
//		bc.payment = ccd;
//		bc.collectPayment(2000.00);
		
		Class<?> clz =  Class.forName("in.shivam.BillCollector");
		
		Object obj = clz.newInstance();
		
		BillCollector bc = (BillCollector) obj;
		
		Field field = clz.getDeclaredField("payment");
		
		field.setAccessible(true);
		
		field.set(obj, new DebitCardPayment());//injecting value to variable
		
		bc.collectPayment(2000.00);
		
	}
}
