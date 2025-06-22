package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/street_food";
        String user = "root";
        String passwd = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Database connected.");
            
            Statement statement = connection.createStatement();

            // SQL query to retrieve all rows from the "Customer" table
            String query = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(query);

            // Process and print the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String loginname = resultSet.getString("loginname");
                String password = resultSet.getString("password");
                
                System.out.println("Customer Name: " + name);
                System.out.println("Login Name: " + loginname);
                System.out.println("Password: " + password);
                System.out.println("--------------------------------");
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
