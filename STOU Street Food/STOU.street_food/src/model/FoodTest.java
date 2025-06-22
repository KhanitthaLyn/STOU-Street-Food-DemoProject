package model;

public class FoodTest 
{

	public static void main(String[] args) 
	{
		Food food1 = new Food("101","Chicken Basil Leave",60);
		System.out.println(food1);
		food1.setId("100");
		food1.setName("Rice");
		food1.setPrice(10);
		System.out.println(food1);
	} 

} 
