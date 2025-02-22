<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            margin-top: 100px;
        }
        .message {
            font-size: 20px;
            color: green;
            font-weight: bold;
        }
        .login-link {
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            display: inline-block;
            margin-top: 20px;
        }
        .login-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="message">
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.println(msg);
            } else {
                out.println("You have been logged out successfully.");
            }
        %>
    </div>

    <br>
   
    <%@include file="home.html" %>

</body>
</html>
