<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IPL Tournament Login</title>

<link rel="stylesheet" href="style.css">

</head>
<body>

    <h2>Admin Login</h2>

    <form action="login" method="post">

        Username:
        <input type="text" name="username" required>
        <br><br>

        Password:
        <input type="password" name="password" required>
        <br><br>

        <input type="submit" value="Login">

    </form>

</body>
</html>