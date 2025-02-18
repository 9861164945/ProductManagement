<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");
out.println("Page Belongs To Admin"+ab.getFname()+"<br>");
out.println(msg);
%>

<a href="Product.html">AddProduct:</a>
<a href="view">ViewAllProduct</a>
<a href="logout">Logout</a>
</body>
</html>