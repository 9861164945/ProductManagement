<%@ page import="com.servlet.ProductManagement.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Status</title>
</head>
<body>
    <%
        CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
        String msg = (String) request.getAttribute("msg");

        if (msg != null) {
            out.println("<h3>" + msg + "</h3>");
        }

        if (cb != null) {
            out.println("<p>Welcome, " + cb.getCfname() + " " + cb.getClname() + "!</p>");
        }
    %>
    <a href="Register.html">Go back to Register Page</a>
</body>
</html>
