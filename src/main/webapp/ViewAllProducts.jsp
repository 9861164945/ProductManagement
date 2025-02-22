<%@page import="java.util.Iterator"%>
<%@page import="com.servlet.ProductManagement.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>s
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
    </style>
</head>
<body>

<%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
    
    out.println(" --Page Belongs to Admin-- " + ab.getFname() + "<br><br>");
    
    if (al == null || al.size() == 0) {
        out.println("Products Not Available..<br>");
    } else {
        out.println("<h1>List Of Products</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Product Code</th>");
        out.println("<th>Product Name</th>");
        out.println("<th>Product Price</th>");
        out.println("<th>Product Quantity</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");
        
        Iterator<ProductBean> it = al.iterator();
        while (it.hasNext()) {
            ProductBean pb = (ProductBean) it.next();
            out.println("<tr>");
            out.println("<td>" + pb.getPcode() + "</td>");
            out.println("<td>" + pb.getPname() + "</td>");
            out.println("<td>" + pb.getPprice() + "</td>");
            out.println("<td>" + pb.getPqty() + "</td>");
            out.println("<td>"
                + "<a href='edit?pcode=" + pb.getPcode() + "'>Edit</a> | "
                + "<form action='delete' method='post' style='display:inline;' onsubmit='return confirm(\"Are you sure you want to delete this product?\");'>"
                + "<input type='hidden' name='pcode' value='" + pb.getPcode() + "'>"
                + "<button type='submit' class='delete-btn'>Delete</button>"
                + "</form>"
                + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
%>

<br>
<nav>
    <a href="AddProduct.html">Add Product</a>
    <a href="AdminLogout.jsp">Logout</a>
</nav>

</body>
</html>
