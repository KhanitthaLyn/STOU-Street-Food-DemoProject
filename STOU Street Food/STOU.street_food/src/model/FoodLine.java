package model;

public class FoodLine 
{
	private Food food;
	private int amount;
	
	public FoodLine(Food food, int amount) {
		this.food = food;
		this.amount = amount;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "FoodLine [food=" + food + ", amount=" + amount + "]";
	}
	
}
