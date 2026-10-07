package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teambean;
import dao.TeamDAO;

@WebServlet("/updateTeam")
public class UpdateTeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Teambean team = new Teambean();

        team.setTeamId(
            Integer.parseInt(request.getParameter("teamId"))
        );

        team.setTeamName(request.getParameter("teamName"));
        team.setCaptain(request.getParameter("captain"));
        team.setHomeCity(request.getParameter("homeCity"));

        TeamDAO dao = new TeamDAO();

        if (dao.updateTeam(team)) {
            response.sendRedirect("viewTeams.jsp");
        } else {
            response.sendRedirect("editTeam.jsp?id=" + team.getTeamId());
        }
    }
}