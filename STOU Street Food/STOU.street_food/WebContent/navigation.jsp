<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Customer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pung Plin Street Food</title>
</head>
<body>
<% 
Customer login = (Customer)request.getSession().getAttribute("login");
%>
<a href="home.jsp">Home</a> | 
<a href="food.jsp">Food</a> | 
<a href="cart.jsp">Cart</a> | 
<a href="order.jsp">Order</a> | 
<a href="payment.jsp">Payment</a> | 
<a href="contact.jsp">Contact</a>
<!--  <a href="#" style="float:right" onClick="MyWindow=window.open('LoginForm.jsp','MyWindow','width=600,height=350'); return false;">Login1</a> --> 

<% 
if(login==null) {
%>
	<a href="login.jsp" style="float:right">Login</a>  |
<%
} else {
%>
<a href="customeroption.jsp" style="float:right"><b><%=login.getName() %></b></a>  |
<% 
}
%>

<hr>  
</body>
</html>