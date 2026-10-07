package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Matchbean;
import dao.matchDAO;

@WebServlet("/addMatch")
public class Matchservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Matchbean match = new Matchbean();

        match.setTeam1(request.getParameter("team1"));
        match.setTeam2(request.getParameter("team2"));
        match.setWinner(request.getParameter("winner"));
        match.setMatchDate(request.getParameter("matchDate"));
        match.setVenue(request.getParameter("venue"));

        System.out.println("Team1 : " + request.getParameter("team1"));
        System.out.println("Team2 : " + request.getParameter("team2"));
        System.out.println("Winner : " + request.getParameter("winner"));
        System.out.println("Match Date : " + request.getParameter("matchDate"));
        System.out.println("Venue : " + request.getParameter("venue"));

        matchDAO dao = new matchDAO();

        if (dao.addMatch(match)) {
            System.out.println("Match Added Successfully");
            response.sendRedirect("dashboard.jsp");
        } else {
            System.out.println("Match Add Failed");
            response.sendRedirect("addMatch.jsp");
        }
    }
}