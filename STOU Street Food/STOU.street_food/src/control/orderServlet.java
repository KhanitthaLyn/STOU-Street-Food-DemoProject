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
 * Servlet implementation class orderServlet
 */
@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		if(customerservice!=null) {
			Customer login = (Customer)request.getSession().getAttribute("login");
			if(login!=null) {
				String invoiceno = customerservice.addOrder(login);
				request.getSession().setAttribute("invoiceno", invoiceno);		
				login.getCart().clean();
				request.getSession().getServletContext().setAttribute("customerservice", customerservice);			
			}
			request.getRequestDispatcher("/order.jsp").forward(request, response); 		
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
