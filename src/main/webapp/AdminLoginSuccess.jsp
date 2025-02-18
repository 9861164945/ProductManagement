<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.servlet.ProductManagement.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
    <%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    if (ab == null) {
        response.sendRedirect("login.html");
        return; // Stop further execution
    }
    %>
    <h2>Welcome Admin: <%= ab.getFname() %></h2>
    <nav>
        <a href="AddProduct.html">Add Product</a> |
        <a href="view">View All Products</a> |
        <a href="logout">Logout</a>
    </nav>
</body>
</html>
