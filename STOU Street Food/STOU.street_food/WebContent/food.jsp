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
		<form action="searchFoodServlet" method="get">  
		keyword <input type="text" name="keyword"> 
		<input type="submit" value="search">  
		</form>  
	</div>
	<br>
<% 
FoodService foodservice = (FoodService) session.getServletContext().getAttribute("foodservice");
if (foodservice != null) {			
    HashMap<String, Food> foundfood = (HashMap<String, Food>) session.getAttribute("foundfood");
    if (foundfood == null) foundfood = foodservice.getFoods();
%>
<table border="0">
<% for (Food f : foundfood.values()) { %>
    <tr>
        <td rowspan="2">
            <img src="<%= f.getPicture() %>" width="50">
        </td>
        <td>
            <%= f.getName() + ", price = " + f.getPrice() + ", picture = " + f.getPicture() %>
        </td>
    </tr>  
    <tr>
        <td>
            <form action="addCartServlet" method="get">  
                Amount <input type="text" name="amount"> 
                <input type="hidden" name="id" value="<%= f.getId() %>">  
                <input type="submit" value="Add Cart">  
            </form>
        </td>
    </tr> 
    <tr height='2' bgcolor="#AAAAAA"><td colspan='2'></td></tr>
<% } %>
</table>
<% 
} else {
    out.println("No foods available");
}
%>

</div>
</body>
</html>