package control;

import java.io.IOException;
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
 * Servlet implementation class addCartServlet
 */
@WebServlet("/addCartServlet")
public class addCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));

		//System.out.println(id+" "+amount);
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		// System.out.println(customerservice);
		if(customerservice!=null) {
			Customer login = (Customer)request.getSession().getAttribute("login");
			String loginnameforguest = "guest";
			if(login==null) login = customerservice.searchCustomerByName(loginnameforguest);
			// System.out.println(login);
			FoodService foodservice = (FoodService)request.getSession().getServletContext().getAttribute("foodservice");
			Food foodfound = foodservice.searchFoodById(id);
			if(foodfound!=null) {
				Cart cart = login.getCart();
				FoodLine foodline = new FoodLine(foodfound,amount);
			    cart.add(foodline);
			    login.setCart(cart);
			    request.getSession().getServletContext().setAttribute("customerservice", customerservice);		
			}
			request.getRequestDispatcher("/food.jsp").forward(request, response);  
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
