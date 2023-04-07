package com.shivam;

import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;

public class Test {
	public static void main(String[] args) throws Exception {
		Order order = new Order();
		
		order.setOrderId(101);
		order.setOrderedBy("Ramesh");
		order.setBillAmt(1500.00);
		order.setOrderStatus("Confirmed");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(order);
		System.out.println(json);
		
		gson.fromJson(new FileReader(new File("order.json")), Order.class);
		
	}
}
