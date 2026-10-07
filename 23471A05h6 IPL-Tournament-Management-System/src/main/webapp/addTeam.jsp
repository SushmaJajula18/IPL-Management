<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Team</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Add Team</h2>

<form action="addTeam" method="post">

    Team Name:
    <input type="text" name="teamName" required>
    <br><br>

    Captain:
    <input type="text" name="captain" required>
    <br><br>

    Home City:
    <input type="text" name="homeCity" required>
    <br><br>

    <input type="submit" value="Add Team">

</form>

<br>

<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>