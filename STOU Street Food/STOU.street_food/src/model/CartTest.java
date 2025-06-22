package model;

public class CartTest 
{

	public static void main(String[] args) 
	{
		FoodService fs = new FoodService();
		
		// create cart
		Cart cart1 = new Cart("C0001");
		// add food in cart
		System.out.println("==== add =====");
		Food food1 = fs.searchFoodByName("Chicken Basil Leave");
		if(food1!=null) cart1.add(new FoodLine(food1,2));
		food1 = fs.searchFoodByName("Seafood salad");
		if(food1!=null) cart1.add(new FoodLine(food1,2));
		food1 = fs.searchFoodByName("Dark eggs Basil Leave");
		if(food1!=null) cart1.add(new FoodLine(food1,2));
		food1 = fs.searchFoodByName("Minced Pork Omellete");
		if(food1!=null) cart1.add(new FoodLine(food1,2));
		food1 = fs.searchFoodByName("Minced Pork Omellete");
		if(food1!=null) cart1.add(new FoodLine(food1,10));		
		// show all food in cart
		System.out.println("==== show =====");
		System.out.println(cart1);		// number of food in cart
		System.out.println(cart1.getFoodlines().size());		
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	// number of box and all price in cart		
		System.out.println();	
		
		// finding food in cart
		System.out.println("==== searching =====");		
		FoodLine found = cart1.searchFoodByName("Minced Pork Omellete");
		System.out.println(found);
		System.out.println();	
		
		// change the number of food 
		System.out.println("==== update =====");
		cart1.getFoodlines().get(cart1.getFoodlines().indexOf(found)).setAmount(10);
		cart1.getFoodlines().get(cart1.getFoodlines().indexOf(cart1.searchFoodByName("Seafood salad"))).setAmount(20);
		System.out.println(cart1);
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	
		System.out.println();	
		
		// delete cart
		System.out.println("==== drop =====");
		cart1.drop(found);
		System.out.println(cart1);
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	
		System.out.println();	
		
		// clear cart
		System.out.println("==== clear =====");
		cart1.clean();
		System.out.println(cart1);		
		System.out.println(cart1.getFoodlines().size());		
		System.out.println(cart1.getTotal()[0] + "   " + cart1.getTotal()[1]);	
				
	} // main
} // CartTest
