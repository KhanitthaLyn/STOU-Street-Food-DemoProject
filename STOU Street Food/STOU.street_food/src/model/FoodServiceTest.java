package model;

import java.util.HashMap;

public class FoodServiceTest 
{
	public static void main(String[] args) 
	{
		Food food1 = new Food("Fried Rice With Pork",60);
		Food food2 = new Food("Chicken Green Curry",80);
		food1.setPrice(50);
		food2.setName("Chicken Red Curry");
		
		FoodService fs = new FoodService();
		// add food
		fs.add(food1);
		fs.add(food2);
		// search food
		String searchingStr = "pork";
		HashMap<String,Food> found = fs.searchFoodsByName(searchingStr);
		System.out.println(found);
		// delete from menu
		fs.drop(food2);	
		// show all menu
		fs.listFood();		
	}
}
