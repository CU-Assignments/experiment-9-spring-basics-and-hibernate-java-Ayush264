<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label>Username:</label> <input type="text" name="username"><br>
        <label>Password:</label> <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
