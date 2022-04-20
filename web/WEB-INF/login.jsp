<%-- 
    Document   : login
    Created on : Apr 20, 2022, 12:22:09 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="enter_username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="text" name="enter_password" value="${password}">
            <br>
            <input type="submit" name="log_in" value="Log In">
            <p>${message}</p>
        </form>
    </body>
</html>