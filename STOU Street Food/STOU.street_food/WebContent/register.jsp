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
<h2> Registration Form </h2>
<form action="registerServlet" method="POST">
	Name <input type="text" name="name" /> 
	<br/><br/>
	Login name <input type="text" name="loginname" /> 
	<br/><br/>
	Password <input type="password" name="password" />
	<br/><br/>
	<input type="submit" value="Register" />		
</form>
</div>
</body>
</html>