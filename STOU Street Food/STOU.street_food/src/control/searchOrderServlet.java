package control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.CustomerService;
import model.Food;
import model.FoodService;
import model.Order;

/**
 * Servlet implementation class searchOrderServlet
 */
@WebServlet("/searchOrderServlet")
public class searchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
        CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
        Customer login = (Customer)request.getSession().getAttribute("login");
		String loginnameforguest = "guest";
		if(login==null) login = customerservice.searchCustomerByLoginname(loginnameforguest);
		HashMap<String,Order> foundorders = customerservice.searchOrdersByFoodName(keyword, login);
		if(foundorders.size()>=0) request.getSession().setAttribute("foundorders", foundorders);
        request.getRequestDispatcher("/orderhistory.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
