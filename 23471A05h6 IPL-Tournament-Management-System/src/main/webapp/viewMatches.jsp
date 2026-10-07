<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Matchbean" %>
<%@ page import="dao.matchDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Matches</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Match List</h2>

<%
    matchDAO dao = new matchDAO();
    ArrayList<Matchbean> list = dao.getAllMatches();
%>

<h3>Total Matches = <%= list.size() %></h3>

<table border="1">

<tr>
    <th>Match ID</th>
    <th>Team 1</th>
    <th>Team 2</th>
    <th>Winner</th>
    <th>Match Date</th>
    <th>Venue</th>
    <th>Action</th>
</tr>

<%
    for(Matchbean match : list){
%>

<tr>
    <td><%= match.getMatchId() %></td>
    <td><%= match.getTeam1() %></td>
    <td><%= match.getTeam2() %></td>
    <td><%= match.getWinner() %></td>
    <td><%= match.getMatchDate() %></td>
    <td><%= match.getVenue() %></td>
    <td>
        <a href="deleteMatch?id=<%= match.getMatchId() %>">
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