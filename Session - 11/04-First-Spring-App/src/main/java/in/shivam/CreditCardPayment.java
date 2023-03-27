package in.shivam;

public class CreditCardPayment implements IPayment {

	public CreditCardPayment(){
		System.out.println("CreditCardPayment :: Constructor");
	}
	public String pay(double amount) {
		// TODO Auto-generated method stub
		return "Payement successfull through Credit card";
	}

}
