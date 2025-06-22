package model;

import java.util.ArrayList;

public class Cart {
	private String id;
	private ArrayList<FoodLine> foodlines;

	
	public Cart(String id) {
		this.id = id;
		foodlines = new ArrayList<>();
	}
	
    public Cart(Cart cart)
    {
		this.id = cart.id;
        this.foodlines = new ArrayList<>(cart.getFoodlines());
    }
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<FoodLine> getFoodlines() {
		return foodlines;
	}

	public void setFoodlines(ArrayList<FoodLine> foodlines) {
		this.foodlines = foodlines;
	}

	public int[] getTotal() {
		int total = 0;
		int count = 0;
		for(int i=0;i<foodlines.size();i++)
		{
			FoodLine temp = foodlines.get(i);
			total = total + temp.getFood().getPrice()*temp.getAmount();
			count = count + temp.getAmount();
		}
		int[] result = {count,total};
		return result;
	}
	
	public FoodLine searchFoodLineByFoodId(String id) {
		FoodLine found = null;
		for(FoodLine f:foodlines) {
			if(f.getFood().getId().equalsIgnoreCase(id)) {
				found = f;
				break;
			}
		}
		return found;
	}

	public ArrayList<FoodLine> searchFoodsByName(String name) {
		ArrayList<FoodLine> found = new ArrayList<>();
		for(FoodLine f:foodlines) {
			if(f.getFood().getName().toLowerCase().contains(name.toLowerCase())) {
				found.add(f);
			}
		}
		return found;
	}
	
	public FoodLine searchFoodLineByFoodName(String name) {
		FoodLine found = null;
		for(FoodLine f:foodlines) {
			if(f.getFood().getId().equalsIgnoreCase(id)) {
				found = f;
				break;
			}
		}
		return found;
	}
	
	public void add(FoodLine foodline){
		FoodLine found = searchFoodByName(foodline.getFood().getName());
		if(found==null) foodlines.add(foodline);
		else found.setAmount(found.getAmount()+foodline.getAmount());
	}
	
	public void drop(FoodLine foodline){
		FoodLine found = searchFoodByName(foodline.getFood().getName());
		if(found!=null) foodlines.remove(foodline);
	}
	
	public void clean(){
		foodlines.clear();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", foodlines=" + foodlines + "]";
	}
	
	public FoodLine searchFoodByName(String name) {
		FoodLine found = null;
		for(FoodLine i : foodlines) {
			if(i.getFood().getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
				found = i;
				break;
			}
		}
		return found;
	}
	

	
} // Cart
