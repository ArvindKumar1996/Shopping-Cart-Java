<%-- 
    Document   : Logout
    Created on : Jul 9, 2018, 5:52:11 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
    <center>
        <h2><u>Online Shopping Cart</u></h2>
        <br>
        <%@page language="java" %>
        <%
            session.invalidate();
            %>
            <br><br><b>
            You have logged out successfully.
            <br><br>
            Return to shopping cart? &nbsp; <a href="login.jsp">Click here</a>
            </b>
    </center>
    </body>
</html>
