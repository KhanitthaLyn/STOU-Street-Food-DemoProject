package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Customer;
import model.CustomerService;
import model.Food;
import model.FoodLine;
import model.FoodService;

/**
 * Servlet implementation class searchCartServlet
 */
@WebServlet("/searchCartServlet")
public class searchCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCartServlet() {
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
        Cart cart = null;
		String loginnameforguest = "guest";
		if(login==null) {
			login = customerservice.searchCustomerByLoginname(loginnameforguest);
			cart = login.getCart(); 
		} else cart = login.getCart();
		ArrayList<FoodLine> found = cart.searchFoodsByName(keyword);
		if(found.size()>=0) request.getSession().setAttribute("foundfoodline", found);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
