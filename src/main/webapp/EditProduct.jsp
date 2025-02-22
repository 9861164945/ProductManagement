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
<input type="hidden" name="pcode" value="<%= pb.getPcode() %>">


<label for="ProductPrice">Productprice:</label>
<input type="text"name="pprice" value=<%=pb.getPprice() %>><br>
<label for="ProductQty">ProductQty:</label>
<input type="text" name="pqty" value=<%=pb.getPqty() %>><br>
<button type="submit">UpdateProduct</button>
</form>
</div>
</body>
</html>