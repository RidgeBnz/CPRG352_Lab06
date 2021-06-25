<%-- 
    Document   : shoppingList
    Created on : Jun 25, 2021, 12:09:51 PM
    Author     : 840288
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List - List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}.</p> 
        <a href="ShoppingList?action=logout">Log Out</a> 
        <h2>List</h2>
        
        <form method="post" action="ShoppingList">
            <label>Add Item: </label>
            <input type="text" name="addItem" value="${item}">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form method="post" action="ShoppingList">
            <ul>
                <c:forEach var="item" items="${items}">
                    <li><input type="radio" name="deleteItem" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
