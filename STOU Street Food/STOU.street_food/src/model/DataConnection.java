package model;

public class DataConnection {	
	private CustomerService customerservice;
	private FoodService foodservice;

	
	public static DataConnection connect(String password) {
		DataConnection dc = null;
		if(password.equals("123"))
		{
			dc = new DataConnection();
			dc.init();
		}
		return dc;
	}
	private void init(){
		customerservice = new CustomerService();
		foodservice = new FoodService();
		String loginnameforguest = "guest";
	}

	public CustomerService getCustomerservice() {
		return customerservice;
	}
	public FoodService getFoodservice() {
		return foodservice;
	}

}
