package in.shivam;

public class DebitCardPayment implements IPayment {

	@Override
	public String pay(double amount) {
		// Logic for Debit Card Payment
		return "Payment successful though Debit Card";
		
	}

}
