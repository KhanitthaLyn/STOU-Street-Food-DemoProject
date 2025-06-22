package model;

public class Order 
{
	Customer customer; // customer name
	Cart cart;
	String invoiceno;
	String howtopay;
	
	public Order(String invoiceno, Customer customer, Cart cart) 
	{
		this.customer = customer;
		this.cart = cart;
		this.invoiceno = invoiceno;
		this.howtopay = null;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getHowtopay() {
		return howtopay;
	}

	public void setHowtopay(String howtopay) {
		this.howtopay = howtopay;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", cart=" + cart + ", invoiceno=" + invoiceno
				+ ", howtopay=" + howtopay + "]";
	}

} // Order
