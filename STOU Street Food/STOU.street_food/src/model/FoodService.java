package model;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodService {
	private HashMap<String,Food> foods;
	private int count;
	
	public FoodService(){
		foods = new HashMap<String,Food>();
		count = 1;
		initFood();
	}

	public HashMap<String, Food> getFoods() {
		return foods;
	}

	public void setFoods(HashMap<String, Food> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "FoodService [foods=" + foods + "]";
	}
	
	public String getFoodNo() {
		return "F00" + count++;
	}
	
	public void add(Food food){
		String id = getFoodNo();
		food.setId(id);
		foods.put(food.getId(), food);
	}
	
	public void initFood(){
		
		/*Food f = new Food("Chicken Basil Leave",60);
		add(f);
		f = new Food("Pork Garlic Pepper",70);
		add(f);
		f = new Food("Minced Pork Omellete",50);
		add(f);
		f = new Food("Seafood Tom Yum",100);
		add(f);
		f = new Food("Dark eggs Basil Leave",80);
		add(f);
		f = new Food("Seafood salad",90);
		add(f);	*/
		
        String url = "jdbc:mysql://localhost:3306/street_food";
        String user = "root";
        String passwd = "12345678";

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, passwd);
            Statement statement = connection.createStatement();

            // SQL query to retrieve all rows from the "customer" table (use lowercase for the table name)
            String query = "SELECT * FROM food order by food_id";
            ResultSet resultSet = statement.executeQuery(query);

            // Process and print the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                String food_name = resultSet.getString("food_name");
                int price = resultSet.getInt("price");
                String picture = resultSet.getString("picture");
                Food f = new Food(food_name,price,picture);
        		add(f);
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
	
	public void drop(Food food){
		foods.remove(food.getId());
	}
	
	public HashMap<String,Food> searchFoodsByName(String name) {
		HashMap<String,Food> found = new HashMap<>();
		for(Food i : foods.values()) {
			if(i.getName().toLowerCase().contains(name.toLowerCase())) {
				found.put(i.getId(), i);
			}
		}
		return found;
	}
	
	public void listFood() {
		System.out.println("========== Menu ("+ foods.size() +")===========");
		int count = 1;
		for(Food i : foods.values()) {
			System.out.println(i);
			count++;
		}
		System.out.println("==============================");
	}	

	public Food searchFoodByName(String name) {
		Food found = null;
		for(Food i : foods.values()) {
			if(i.getName().equalsIgnoreCase(name)) {
				found = i;
				break;
			}
		}
		return found;
	}

	public Food searchFoodById(String id) {
		Food found = null;
		for(Food i : foods.values()) {
			if(i.getId().equalsIgnoreCase(id)) {
				found = i;
				break;
			}
		}
		return found;
	}
}
