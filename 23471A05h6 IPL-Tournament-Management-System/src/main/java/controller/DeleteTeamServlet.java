package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDAO;

@WebServlet("/deleteTeam")
public class DeleteTeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int teamId = Integer.parseInt(request.getParameter("id"));

        TeamDAO dao = new TeamDAO();

        dao.deleteTeam(teamId);

        response.sendRedirect("viewTeams.jsp");
    }
}