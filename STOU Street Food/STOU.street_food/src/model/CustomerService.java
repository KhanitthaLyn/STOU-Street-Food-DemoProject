package model;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class CustomerService 
{
	private HashMap<String,Customer> customers;
	private int count;
	private int ordercount;

	public CustomerService(HashMap<String, Customer> customers) {
		this();
		this.customers = customers;
	}

	public CustomerService() {
		customers = new HashMap<String,Customer>();
		count = 1;
		ordercount = 1;
		initCustomer();
	}

	public HashMap<String, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<String, Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerService [customers=" + customers + "]";
	}

	public String getCustomerNo() {
		return "C00" + count++;
	}
	
	public String getInvoiceNo() {
		return "I00" + ordercount++;
	}
	
	public void add(Customer customer){
		String id = getCustomerNo();
		customer.setId(id);
		customers.put(customer.getId(), customer);
	}

	public void drop(Customer customer){
		customers.remove(customer.getId());
	}
	
	public Customer validLogin(String loginname, String password)
	{
		Customer c = null;
		for(Customer i : customers.values())
		{
			if(i.getLoginname().equals(loginname) && i.getPassword().equals(password))
			{
				c = i;
				break;
			}
		}
		return c;
	}
	
	public void initCustomer()
	{
		/*add(new Customer("C000","guest","guest",""));
		Customer c1 = new Customer("Manee","manee","1234");
		add(c1);
		c1 = new Customer("Chujai","chujai","1234");
		add(c1);
		c1 = new Customer("Petch","petch","1234");
		add(c1);
		c1 = new Customer("Piti","piti","1234");
		add(c1);*/
		
		add(new Customer("C000","guest","guest",""));
        String url = "jdbc:mysql://localhost:3306/street_food";
        String user = "root";
        String passwd = "12345678";

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, passwd);
            Statement statement = connection.createStatement();

            // SQL query to retrieve all rows from the "customer" table (use lowercase for the table name)
            String query = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(query);

            // Process and print the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                String name = resultSet.getString("name");
                String loginname = resultSet.getString("loginname");
                String password = resultSet.getString("password");
                Customer c1 = new Customer(name, loginname, password);
                add(c1);
            }

            // Close the connection and release resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load the MySQL JDBC driver.", e);
        }

	}
	
	public Customer searchCustomerByName(String name) {
		Customer found = null;
		for(Customer i : customers.values()) {
			if(i.getName().equalsIgnoreCase(name)) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	public Customer searchCustomerByLoginname(String name) {
		Customer found = null;
		for(Customer i : customers.values()) {
			if(i.getLoginname().equalsIgnoreCase(name)) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	public void listCustomer() {
		System.out.println("========== Members ("+ customers.size() +")===========");
		int count = 1;
		for(Customer i : customers.values()) {
			System.out.println(i);
			count++;
		}
		System.out.println("==============================");
	}
	
	public Customer searchCustomerByLoginnameAndPassword(String loginname,String password) {
		Customer found = null;
		  for(Customer m:customers.values()){  
			   if(m.getLoginname().equals(loginname) && m.getPassword().equals(password)) {
				   found = m;
				   break;
			   }
			  }  
		return found;
	}
	
	public HashMap<String,Order> searchOrdersByLoginname(String loginname) {
		Customer c = searchCustomerByLoginname(loginname);
		HashMap<String,Order> found = new HashMap<>();
		if(c!=null) {
			found = c.getOrders();
		}
		return found;
	}
	
	public HashMap<String,Order> searchOrdersByFoodName(String foodname, Customer customer) {
		HashMap<String,Order> found = new HashMap<>();
		HashMap<String,Order> orders = customer.getOrders();
		for(Order i:orders.values()) {
			Cart cart = i.getCart();
			for(FoodLine j: cart.getFoodlines()) {
				if(j.getFood().getName().toLowerCase().contains(foodname.toLowerCase())) {
					found.put(i.getInvoiceno(), i);
				}	
			}
		}
		return found;
	}
	
	public Order searchOrdersByInvoiceno(String invoiceno, Customer customer) {
		Order found = null;
		Customer c = searchCustomerByLoginname(customer.getLoginname());
		if(c!=null) {
			for(Order i:c.getOrders().values()) {
				if(i.getInvoiceno().equalsIgnoreCase(invoiceno)) {
					found = i;
					break;					
				}
			}
		}
		return found;
	}
		
	public String addOrder(Customer customer) {
		String invoiceno = getInvoiceNo();
		Cart copiedCart = new Cart(customer.getCart());
		customer.getOrders().put(invoiceno, new Order(invoiceno,customer,copiedCart));
		return invoiceno;
	}
}
