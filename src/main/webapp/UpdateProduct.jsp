<%@page import="com.servlet.ProductManagement.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>

<% 
// Get session attributes
AdminBean ab = (AdminBean) session.getAttribute("abean");
String msg = (String) request.getAttribute("msg");

// Check if admin session exists
if (ab != null) { 
%>
    <p>Page Belongs to Admin: <strong><%= ab.getFname() %></strong></p>
<% 
} else { 
%>
    <p style="color:red;">❌ ERROR: No admin session found.</p>
<% 
} 

// Display message if available
if (msg != null) { 
%>
    <p style="color:blue;"><%= msg %></p>
<% 
} 
%>

</body>
</html>
