package model;

public class Food 
{
	private String id;
	private String name;
	private int price;
	private String picture;
	
	public Food(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Food(String name, int price) {
		this.id = "F0000";
		this.name = name;
		this.price = price;
	}
	
	public Food(String name, int price, String picture) {
		this.id = "F0000";
		this.name = name;
		this.price = price;
		this.picture = picture;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getPicture() {
		return picture;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", Name=" + name + ", price=" + price + "]";
	}
	
	
	
} // class
