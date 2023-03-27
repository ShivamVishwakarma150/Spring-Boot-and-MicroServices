package in.shivam;

public class BillCollector {
	private IPayment payment;
	
	public void setPayment(IPayment payment) {
		System.out.println("setPayment() :: executed");
		this.payment = payment;
	}
	
	public BillCollector() {
		
	}
	
	public BillCollector(IPayment payment) 	{
		System.out.println("BillCollector() :: Param Constructor");
		this.payment=payment;
	}
	
	public void collectPayment(double amount) {
		
		System.out.println("Injected :: "+payment.getClass().getName());
		String status = payment.pay(amount);
		
		System.out.println(status);
	}
}
