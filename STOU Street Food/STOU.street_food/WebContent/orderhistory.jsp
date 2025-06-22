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
    <div>
		<form action="searchOrderServlet" method="get">  
		keyword <input type="text" name="keyword"> 
		<input type="submit" value="search">  
		</form>  
	</div>
	<br>
	<div> Order History </div>
	<div>
	<% 
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		if(customerservice!=null) {
			Customer currentlogin = (Customer)request.getSession().getAttribute("login");
			String loginnameforguest = "guest";
			if(currentlogin==null) currentlogin = customerservice.searchCustomerByLoginname(loginnameforguest);
			
			HashMap<String,Order> orders = (HashMap<String,Order>)session.getAttribute("foundorders");
			if(orders==null)  orders =currentlogin.getOrders();

			if(orders.size()>0){
				for(Order i: orders.values()){
					out.println("------------------------------------------<br>");
					out.println("Invoice No. : "+ i.getInvoiceno()+"<br>");
					Cart cart = i.getCart();
					for(FoodLine f:cart.getFoodlines()){
						Food food = f.getFood();
						out.println(food.getName()+ ", price = " + food.getPrice() + " -> " + f.getAmount());				
						out.println("<br>");
					}			
					out.println("No. of Food : " + i.getCart().getFoodlines().size()+ "<br>");
					out.println("Total Boxes : " + i.getCart().getTotal()[0]+ "<br>");
					out.println("Total Price : " + i.getCart().getTotal()[1]+ "<br>");
				}
			} else out.println("no order");
		}
	%>	
	
	
	</div>

</div>
</body>
</html>