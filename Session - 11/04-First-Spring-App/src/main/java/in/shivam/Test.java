package in.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		
		//I am giving my beans configuration file as a input for IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
	
		// get object from IOC
		BillCollector bc =  context.getBean("billCollector",BillCollector.class);
		bc.collectPayment(1400.00);
		
		
		
	}
}
