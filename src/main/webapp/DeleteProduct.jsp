<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .message {
            font-size: 18px;
            padding: 10px;
            margin: 10px auto;
            width: 50%;
            border-radius: 5px;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
        a {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            font-weight: bold;
            color: #007bff;
        }
    </style>
</head>
<body>
    <%
        String msg = (String) request.getAttribute("msg");
        boolean isSuccess = msg != null && msg.contains("✅");
    %>

    <div class="message <%= isSuccess ? "success" : "error" %>">
        <%= msg != null ? msg : "No message available." %>
    </div>

    <a href="view">⬅️ Back to Product List</a>
</body>
</html>
