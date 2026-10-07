<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String user = (String) session.getAttribute("user");

    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link rel="stylesheet" href="style.css">

</head>
<body>

<h1>IPL Tournament Management System</h1>

<p>
    Welcome, <b><%= user %></b>
</p>

<a href="logout">Logout</a>

<hr>

<h3>Team Module</h3>

<a href="addTeam.jsp">Add Team</a>
<br><br>

<a href="viewTeams.jsp">View Teams / Edit / Delete</a>

<hr>

<h3>Player Module</h3>

<a href="addPlayer.jsp">Add Player</a>
<br><br>

<a href="viewPlayers.jsp">View Players / Edit / Delete</a>

<hr>

<h3>Match Module</h3>

<a href="addMatch.jsp">Add Match</a>
<br><br>

<a href="viewMatches.jsp">View Matches / Edit / Delete</a>

</body>
</html>