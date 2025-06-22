package model;

import java.util.HashMap;

public class Customer 
{
	// profile
	private String id;
	private String name;
	private String loginname;
	private String password;
	
	// transaction
	private Cart cart;
	private HashMap<String,Order> orders;
	
	public Customer(String id, String name, String loginname, String password) {
		this.id = id;
		this.name = name;
		this.loginname = loginname;
		this.password = password;
		this.cart = new Cart(id);
		this.orders = new HashMap<>();
	}
	
	public Customer(String name, String loginname, String password) {
		this.id = "C0000";
		this.name = name;
		this.loginname = loginname;
		this.password = password;
		this.cart = new Cart(id);
		this.orders = new HashMap<>();
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
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public HashMap<String, Order> getOrders() {
		return orders;
	}
	public void setOrders(HashMap<String, Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", loginname=" + loginname + ", password=" + password
				+ ", cart=" + cart + ", orders=" + orders + "]";
	}		
	

} // Customer
