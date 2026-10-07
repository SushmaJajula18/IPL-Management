<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Teambean" %>
<%@ page import="dao.TeamDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Teams</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Team List</h2>

<%
    TeamDAO dao = new TeamDAO();
    ArrayList<Teambean> list = dao.getAllTeams();
%>

<h3>Total Teams = <%= list.size() %></h3>

<table border="1">

<tr>
    <th>ID</th>
    <th>Team Name</th>
    <th>Captain</th>
    <th>Home City</th>
    <th>Action</th>
</tr>

<%
    for(Teambean team : list){
%>

<tr>
    <td><%= team.getTeamId() %></td>
    <td><%= team.getTeamName() %></td>
    <td><%= team.getCaptain() %></td>
    <td><%= team.getHomeCity() %></td>

    <td>
        <a href="editTeam.jsp?id=<%= team.getTeamId() %>">
            Edit
        </a>

        |

        <a href="deleteTeam?id=<%= team.getTeamId() %>"
           onclick="return confirm('Are you sure you want to delete this team?')">
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