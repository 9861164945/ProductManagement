<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.servlet.ProductManagement.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Welcome admin:"+ab.getFname()+"<br>");

%>
<a href="Product.html">AddProduct</a>
<a href="view">ViewAllProducts</a>
<a href="logout">Logout</a>

</body>
</html>