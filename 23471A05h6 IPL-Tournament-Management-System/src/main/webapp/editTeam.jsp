<%@ page import="dao.TeamDAO" %>
<%@ page import="bean.Teambean" %>

<%
    int teamId = Integer.parseInt(request.getParameter("id"));

    TeamDAO dao = new TeamDAO();

    Teambean team = dao.getTeamById(teamId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Team</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Edit Team</h2>

<form action="updateTeam" method="post">

    <input type="hidden" name="teamId"
           value="<%= team.getTeamId() %>">

    Team Name:
    <input type="text" name="teamName"
           value="<%= team.getTeamName() %>">
    <br><br>

    Captain:
    <input type="text" name="captain"
           value="<%= team.getCaptain() %>">
    <br><br>

    Home City:
    <input type="text" name="homeCity"
           value="<%= team.getHomeCity() %>">
    <br><br>

    <input type="submit" value="Update Team">

</form>

</body>
</html>