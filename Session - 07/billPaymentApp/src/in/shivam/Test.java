package in.shivam;

public class Test {
	public static void main(String[] args) {
		BillCollector bc = new BillCollector();
		
		// setter injection is the process of injecting one class object into another class object
		// Injecting CreditCard obj into BillCollector (Setter Injection)
        bc.setPayment(new CreditCardPayment());
		bc.collectPayment(250.00);
		
		//constructor injection
		// Another Approach to do the injection
		// injecting CreditCard obj into BillCollector (Constructor Injection)
		BillCollector bc1 = new BillCollector(new CreditCardPayment());
		bc1.collectPayment(150.00);
	}
}
