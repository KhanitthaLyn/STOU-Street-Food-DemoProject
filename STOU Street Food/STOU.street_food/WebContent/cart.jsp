<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@	page import="model.*" %>
<%@	page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lyn Street Food</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<div>
   <div>
		<form action="searchCartServlet" method="get">  
		keyword <input type="text" name="keyword"> 
		<input type="submit" value="search">  
		</form>  
	</div>
	<br>
	<div> Cart </div>
	<% 
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		if(customerservice!=null) {
			Customer currentlogin = (Customer)request.getSession().getAttribute("login");
			String loginnameforguest = "guest";
			if(currentlogin==null) currentlogin = customerservice.searchCustomerByLoginname(loginnameforguest);
			
			ArrayList<FoodLine> foundfoodline = (ArrayList<FoodLine>)session.getAttribute("foundfoodline");
			if(foundfoodline==null)  foundfoodline =currentlogin.getCart().getFoodlines();
			
			for(FoodLine f:foundfoodline){
				Food food = f.getFood();
				out.println(food.getName()+ ", price = " + food.getPrice());
				%>
				<form action="deleteFoodInCartServlet" method="get">  
				Amount <input type="text" name="amount" value=<%=f.getAmount()%>> 
				<input type="hidden" name="id" value=<%=food.getId()%>>  
				<input type="submit" value="Delete">  
				</form>  
				<% 				
				out.println("<br>");
			}		
			out.println("No. of Food : " + currentlogin.getCart().getFoodlines().size()+ "<br>");
			out.println("Total Boxes : " + currentlogin.getCart().getTotal()[0]+ "<br>");
			out.println("Total Price : " + currentlogin.getCart().getTotal()[1]+ "<br>");
		}
	%>
		    <form action="orderServlet" method="get">  
				<input type="submit" value="Order">  
			</form>  
</div>
</body>
</html>
