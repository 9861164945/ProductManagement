<%@page import="java.util.Iterator"%>
<%@page import="com.servlet.ProductManagement.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@page import="com.servlet.ProductManagement.CustomerBean"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        h1 {
            text-align: center;
            border: 2px dotted black;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 30px auto;
            text-align: center;
        }
        table, th, td {
            border: 2px solid black;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
        nav {
            margin: 30px auto;
            text-align: center;
        }
        nav a {
            text-decoration: none;
            color: white;
            background-color: #28a745;
            padding: 10px 15px;
            margin: 5px;
            border-radius: 5px;
            display: inline-block;
            font-weight: bold;
        }
        .delete-btn {
            background-color: red;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .buy-btn, .cart-btn {
            padding: 5px 10px;
            cursor: pointer;
            border: none;
            color: white;
            border-radius: 5px;
        }
        .buy-btn {
            background-color: blue;
        }
        .cart-btn {
            background-color: orange;
        }
    </style>
</head>
<body>

<%
    AdminBean admin = (AdminBean) session.getAttribute("abean");
    CustomerBean customer = (CustomerBean) session.getAttribute("cbean");
    ArrayList<ProductBean> productList = (ArrayList<ProductBean>) session.getAttribute("alist");

    if (admin != null) {
        out.println("<p> -- Page Belongs to Admin -- " + admin.getFname() + "</p>");
    } else if (customer != null) {
        out.println("<p> -- Welcome Customer: " + customer.getCfname() + " -- </p>");
    } else {
        out.println("<p style='color:red;'>You are not logged in. <a href='Login.jsp'>Login</a></p>");
        return;
    }

    if (productList == null || productList.isEmpty()) {
        out.println("<p>Products Not Available..</p>");
    } else {
        out.println("<h1>List Of Products</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Product Code</th>");
        out.println("<th>Product Name</th>");
        out.println("<th>Product Price</th>");
        out.println("<th>Product Quantity</th>");
        out.println("<th>Actions</th>"); // Actions for both Admin & Customer
        out.println("</tr>");
        
        for (ProductBean product : productList) {
            out.println("<tr>");
            out.println("<td>" + product.getPcode() + "</td>");
            out.println("<td>" + product.getPname() + "</td>");
            out.println("<td>" + product.getPprice() + "</td>");
            out.println("<td>" + product.getPqty() + "</td>");
            
            out.println("<td>");
            if (admin != null) { 
                // Admin: Edit & Delete Options
                out.println("<a href='edit?pcode=" + product.getPcode() + "'>Edit</a> | "
                    + "<form action='delete' method='post' style='display:inline;' onsubmit='return confirm(\"Are you sure you want to delete this product?\");'>"
                    + "<input type='hidden' name='pcode' value='" + product.getPcode() + "'>"
                    + "<button type='submit' class='delete-btn'>Delete</button>"
                    + "</form>");
            } else if (customer != null) { 
                // Customer: Buy & Add to Cart Buttons
                out.println("<form action='buy' method='post' style='display:inline; margin-right:5px;'>"
                    + "<input type='hidden' name='pcode' value='" + product.getPcode() + "'>"
                    + "<button type='submit' class='buy-btn'>Buy</button>"
                    + "</form>");
                out.println("<form action='addtocart' method='post' style='display:inline;'>"
                    + "<input type='hidden' name='pcode' value='" + product.getPcode() + "'>"
                    + "<button type='submit' class='cart-btn'>Add to Cart</button>"
                    + "</form>");
            }
            out.println("</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
%>

<br>
<nav>
    <% if (admin != null) { %>
        <a href="AddProduct.html">Add Product</a>
        <a href="AdminLogout.jsp">Logout</a>
    <% } else if (customer != null) { %>
        <a href="ViewCart.jsp">View Cart</a>
        <a href="CustomerLogout.jsp">Logout</a>
    <% } %>
</nav>

</body>
</html>
