<%-- 
    Document   : register
    Created on : Jun 25, 2021, 12:09:19 PM
    Author     : 840288
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List - Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <label>Username: </label>
            <input type="text" name="username" autofocus>
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register">
            <br>
            <p>${message}</p>
        </form>
    </body>
</html>
