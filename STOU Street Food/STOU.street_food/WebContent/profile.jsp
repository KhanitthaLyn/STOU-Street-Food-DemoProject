<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<div> Profile </div>
	<div>
	<% 
		CustomerService customerservice = (CustomerService)request.getSession().getServletContext().getAttribute("customerservice");
		if(customerservice!=null) {
			Customer currentlogin = (Customer)request.getSession().getAttribute("login");
			if(currentlogin!=null) {
				out.println("Name : "+currentlogin.getName()+ "<br>");
				out.println("Login Name : "+currentlogin.getLoginname()+ "<br>");
				out.println("Password : "+currentlogin.getPassword()+ "<br>");
			}
		}
	%>
	<a href="editprofile.jsp">Edit</a> | 
    <a href="deleteServlet">Delete</a> | <br>
    <a href="orderhistory.jsp">Order History</a> | 
   	</div>
</div>
</body>
</html>