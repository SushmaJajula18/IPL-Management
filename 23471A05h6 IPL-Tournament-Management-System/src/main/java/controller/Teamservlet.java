package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teambean;
import dao.TeamDAO;

@WebServlet("/addTeam")
public class Teamservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Teambean team = new Teambean();

        team.setTeamName(request.getParameter("teamName"));
        team.setCaptain(request.getParameter("captain"));
        team.setHomeCity(request.getParameter("homeCity"));

        System.out.println("Team Name = " + request.getParameter("teamName"));
        System.out.println("Captain = " + request.getParameter("captain"));
        System.out.println("Home City = " + request.getParameter("homeCity"));

        TeamDAO dao = new TeamDAO();

        if (dao.addTeam(team)) {
            System.out.println("Team Added Successfully");
            response.sendRedirect("dashboard.jsp");
        } else {
            System.out.println("Team Add Failed");
            response.sendRedirect("addTeam.jsp");
        }
    }
}