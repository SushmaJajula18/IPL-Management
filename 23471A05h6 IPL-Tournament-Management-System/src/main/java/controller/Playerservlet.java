package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Playerbean;
import dao.PlayerDAO;

@WebServlet("/addPlayer")
public class Playerservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Playerbean player = new Playerbean();

        player.setPlayerName(request.getParameter("playerName"));
        player.setRole(request.getParameter("role"));
        player.setTeamId(Integer.parseInt(request.getParameter("teamId")));

        PlayerDAO dao = new PlayerDAO();

        if (dao.addPlayer(player)) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("addPlayer.jsp");
        }
    }
}