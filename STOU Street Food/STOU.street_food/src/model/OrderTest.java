package model;

public class OrderTest 
{

	public static void main(String[] args) 
	{
		FoodService fs = new FoodService();
		Customer c1 = new Customer("22","Paitoon","paitoon","1234");		
		// put into cart
		Cart cart1 = new Cart(c1.getId());
		FoodLine foodline1 = new FoodLine(fs.getFoods().get("101"),2);
		cart1.add(foodline1);
		FoodLine foodline2 = new FoodLine(fs.getFoods().get("102"),2);
		cart1.add(foodline2);		
		FoodLine foodline3 = new FoodLine(fs.getFoods().get("103"),2);
		cart1.add(foodline3);		
		FoodLine foodline4 = new FoodLine(fs.getFoods().get("104"),2);
		cart1.add(foodline4);	
		
/*		System.out.println(cart1);
		
		System.out.println(cart1.getFoodlines().size());
		
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	
		
		foodline1.setAmount(10);
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	
*/
		
		// order
		Order order = new Order("111",c1,cart1);
		System.out.println(order);
				
	}

}
