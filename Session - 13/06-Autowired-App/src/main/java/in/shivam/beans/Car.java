package in.shivam.beans;

public class Car {
	private DieselEngine dieselEng;
	
	public void setDieselEng(DieselEngine dieselEng) {
		this.dieselEng=dieselEng;
	}
	
	public Car() {
		System.out.println("Car::Constructor");
	}
	
	public void drive() {
		int start = dieselEng.start();
		if(start>=1) {
			System.out.println("journey Starter...");
			
		}
		else {
			System.out.println("Engine Failed to Start...!!");
		}
			
	}
	
}
