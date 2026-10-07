<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Player</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Add Player</h2>

<form action="addPlayer" method="post">

    Player Name:
    <input type="text" name="playerName" required>
    <br><br>

    Role:
    <input type="text" name="role" required>
    <br><br>

    Team ID:
    <input type="number" name="teamId" required>
    <br><br>

    <input type="submit" value="Add Player">

</form>

<br>

<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>