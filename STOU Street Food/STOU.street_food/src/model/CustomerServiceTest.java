package model;

public class CustomerServiceTest 
{

	public static void main(String[] args) 
	{
		// crete customer
		Customer c1 = new Customer("Urai","urai", "1234");
		c1.setPassword("urairakdee");
		Customer c2 = new Customer("Paitoon","paitoon","1234");
		c2.setName("Paitoon Rakrien");
		
		CustomerService cs = new CustomerService();
		// add customer
		cs.add(c1);
		cs.add(c2);
		// find customer
		String searchingStr = "urai";
		Customer found = cs.searchCustomerByName(searchingStr);
		System.out.println(found);
		// delete customer
		cs.drop(c2);
		// show all customer
		cs.listCustomer();		
	}
}
