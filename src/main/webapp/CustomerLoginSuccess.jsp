<%@page import="com.servlet.ProductManagement.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin.css">

</head>
<body>
<%
CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
if(cb==null)
{
	
	 response.sendRedirect("CustomerLogin.html");
	 return;
}

%>
<header>Welcome User :<%=cb.getCfname() %></header>

<nav>
<a href="view">View All Products</a>
 <a href="clogout">Logout</a>

</nav>

</body>
</html>