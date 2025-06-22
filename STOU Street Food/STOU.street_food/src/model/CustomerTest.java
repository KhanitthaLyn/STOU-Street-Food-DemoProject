package model;

public class CustomerTest {

	public static void main(String[] args) 
	{
		Customer c1 = new Customer("11","Manee","manee","11111");
		c1.setLoginname("manee11");
		c1.setPassword("1234");
		System.out.println(c1);
		
		Customer c2 = new Customer("12","Chujai","chujai12","1234");
		System.out.println(c2);

	}

}
