<%-- 
    Document   : login
    Created on : Dec 12, 2025, 2:01:13 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <h2> Login</h2>
        <form action="login"  method="post"> 
         <label>Username: <input type="text" name="user" required></label><br><br>
        <label>Password: <input type="password" name="password" required></label><br><br>
        <input type="submit" value="Login">
        </form>
    </body>
</html>


