<%@page import="java.util.Iterator"%>
<%@page import="com.servlet.ProductManagement.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
    
    out.println("Page Belongs to Admin: " + ab.getFname() + "<br><br>");
    
    if (al == null || al.size() == 0) {
        out.println("Products Not Available..<br>");
    } else {
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
                + "<a href='delete?pcode=" + pb.getPcode()+ "'>Delete</a>"
                + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
%>

<br>
<a href="AddProduct.html">Add Product</a>
<a href="Logout">Logout</a>

</body>
</html>
