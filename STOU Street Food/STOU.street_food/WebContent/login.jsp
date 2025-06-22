<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pung Plin Street Food</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>

<div align="center">
	<h2>Login</h2>  
	<form action="loginServlet" method="post">  
	Login Name <input type="text" name="loginname"><br/><br/> 
	Password <input type="password" name="password"><br/><br/> 
	<input type="submit" value="Login">  
	</form>  
	Not a member ? <a href="register.jsp">Register</a> 
</div>
</body>
</html>