<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Match</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Add Match</h2>

<form action="addMatch" method="post">

    Team 1:
    <input type="text" name="team1" required>
    <br><br>

    Team 2:
    <input type="text" name="team2" required>
    <br><br>

    Winner:
    <input type="text" name="winner">
    <br><br>

    Match Date:
    <input type="date" name="matchDate">
    <br><br>

    Venue:
    <input type="text" name="venue">
    <br><br>

    <input type="submit" value="Add Match">

</form>

<br>

<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>