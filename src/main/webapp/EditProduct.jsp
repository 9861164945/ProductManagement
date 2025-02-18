<%@page import="com.servlet.ProductManagement.ProductBean"%>
<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="form.css">
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
ProductBean pb=(ProductBean)request.getAttribute("pbean");
out.println("Page Belongs to Admin:"+ab.getFname()+"<br>");



%>
<div class="form-control">
<form action="update" method="post">

<label for="ProductPrice">Productprice:</label>
<input type="text"name="pprice" value=<%=pb.getPrice() %>><br>
<label for="ProductQty">ProductQty:</label>
<input type="text" name="pqty" value=<%=pb.getQty() %>><br>
<button type="submit">UpdateProduct</button>
</form>
</div>
</body>
</html>