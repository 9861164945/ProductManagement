<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.servlet.ProductManagement.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="admin.css">
   </head>
<body>
    <%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    if (ab == null) {
        response.sendRedirect("login.html");
        return;
    }
    %>

    <header>Welcome Admin: <%= ab.getFname() %></header>

    <nav>
        <a href="AddProduct.html">Add Product</a>
        <a href="view">View All Products</a>
        <a href="logout">Logout</a>
    </nav>

    <div class="container">
        <h3>Manage your products efficiently from here.</h3>
    </div>
</body>
</html>
