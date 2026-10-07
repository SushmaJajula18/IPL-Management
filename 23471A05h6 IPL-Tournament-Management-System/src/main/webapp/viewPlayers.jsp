<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Playerbean" %>
<%@ page import="dao.PlayerDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Players</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Player List</h2>

<%
    PlayerDAO dao = new PlayerDAO();
    ArrayList<Playerbean> list = dao.getAllPlayers();
%>

<h3>Total Players = <%= list.size() %></h3>

<table border="1">

<tr>
    <th>Player ID</th>
    <th>Player Name</th>
    <th>Role</th>
    <th>Team ID</th>
    <th>Action</th>
</tr>

<%
    for(Playerbean player : list){
%>

<tr>
    <td><%= player.getPlayerId() %></td>
    <td><%= player.getPlayerName() %></td>
    <td><%= player.getRole() %></td>
    <td><%= player.getTeamId() %></td>
<td>
    <a href="editPlayer.jsp?id=<%= player.getPlayerId() %>">
        Edit
    </a>

    |

    <a href="deletePlayer?id=<%= player.getPlayerId() %>">
        Delete
    </a>
</td>
</tr>

<%
    }
%>

</table>

<br>

<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>