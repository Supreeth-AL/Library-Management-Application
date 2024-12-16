<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Book Added</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .message {
            border: 1px solid #4CAF50;
            background-color: #f9f9f9;
            padding: 20px;
            margin: 10px 0;
            border-radius: 5px;
            color: #4CAF50;
        }
    </style>
</head>
<body>
<%
    String bookName = (String) request.getAttribute("bookName");
%>

<h1>Book Successfully Added!</h1>

<div class="message">
    <p>The book <strong><%= bookName %></strong> has been successfully added to your borrow history.</p>
    <p>Thank you for using our library management system!</p>
</div>

<a href="index.jsp">Go back to the homepage</a> <!-- Adjust the link as needed -->
</body>
</html>
