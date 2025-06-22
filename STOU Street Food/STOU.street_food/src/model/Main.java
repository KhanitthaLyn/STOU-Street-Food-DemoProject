package model;

import java.time.LocalDate;

public class Main {
	CustomerService customerservice;
	FoodService foodservice;
	public void init() {
		String password = "123";
		DataConnection dc = DataConnection.connect(password);
		if(dc != null)
		{
			System.out.println("Service Open");
			customerservice = dc.getCustomerservice();
			foodservice = dc.getFoodservice();
			
		} else 
		{
			System.out.println("Service closed");
		}
	}
		
	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}
}
