<%@ page import="dao.PlayerDAO" %>
<%@ page import="bean.Playerbean" %>

<%
String id = request.getParameter("id");

if(id == null || id.trim().isEmpty()){
    response.sendRedirect("viewPlayers.jsp");
    return;
}

int playerId = Integer.parseInt(id);

PlayerDAO dao = new PlayerDAO();
Playerbean player = dao.getPlayerById(playerId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Player</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Edit Player</h2>

<form action="updatePlayer" method="post">

    <input type="hidden" name="playerId"
           value="<%= player.getPlayerId() %>">

    Player Name:
    <input type="text" name="playerName"
           value="<%= player.getPlayerName() %>" required>
    <br><br>

    Role:
    <input type="text" name="role"
           value="<%= player.getRole() %>" required>
    <br><br>

    Team ID:
    <input type="number" name="teamId"
           value="<%= player.getTeamId() %>" required>
    <br><br>

    <input type="submit" value="Update Player">

</form>

<br>
<a href="viewPlayers.jsp">Back to Players</a>

</body>
</html>