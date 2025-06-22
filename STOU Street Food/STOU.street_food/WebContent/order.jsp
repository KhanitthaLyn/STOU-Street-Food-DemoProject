<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	page import="java.util.HashMap" %>
<%@	page import="model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pung Plin Street Food</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<div>

	<div> Order </div>
	<% 
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		if(customerservice!=null) {
			Customer currentlogin = (Customer)request.getSession().getAttribute("login");
			String loginnameforguest = "guest";
			if(currentlogin==null) currentlogin = customerservice.searchCustomerByLoginname(loginnameforguest);
			String invoiceno = (String)request.getSession().getAttribute("invoiceno");
			if(invoiceno!=null){
				Order order = customerservice.searchOrdersByInvoiceno(invoiceno, currentlogin);
				if(order!=null) {
					out.println("Invoice No. : "+ order.getInvoiceno()+"<br>");
					out.println("======= Foods =============="+"<br>");
					Cart cart = order.getCart();
					for(FoodLine f:cart.getFoodlines()){
						Food food = f.getFood();
						out.println(food.getName()+ ", price = " + food.getPrice() + " -> " + f.getAmount());				
						out.println("<br>");
					}		
					out.println("============================"+"<br>");				
					out.println("No. of Food : " + order.getCart().getFoodlines().size()+ "<br>");
					out.println("Total Boxes : " + order.getCart().getTotal()[0]+ "<br>");
					out.println("Total Price : " + order.getCart().getTotal()[1]+ "<br>");
				}
			}
		}
	%>
		    <form action="payServlet" method="get">  
				<input type="submit" value="Pay">  
			</form>  
</div>
</body>
</html>