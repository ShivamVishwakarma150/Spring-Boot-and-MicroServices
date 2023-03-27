package in.shivam;

public class DebitCardPayment implements IPayment {

	public DebitCardPayment(){
		System.out.println("DebitCardPayment :: Constructor");
	}
	public String pay(double amount) {
		// Logic for Debit Card Payment
		return "Payment successful though Debit Card";
		
	}

}
