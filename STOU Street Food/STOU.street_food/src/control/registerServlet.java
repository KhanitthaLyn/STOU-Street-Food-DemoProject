package control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");  
        String loginname=request.getParameter("loginname");  
        String password=request.getParameter("password");

    	CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
        Customer customer = new Customer(name,loginname,password);
//        System.out.println(customer);
        customerservice.add(customer);
        
        String url = "jdbc:mysql://localhost:3306/street_food";
        String user = "root";
        String passwd = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, user, passwd);            
            String sql = "INSERT INTO customer (name, loginname, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, loginname);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    	request.getSession().getServletContext().setAttribute("customerservice",customerservice);         
    	request.getRequestDispatcher("login.jsp").forward(request, response);  		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
