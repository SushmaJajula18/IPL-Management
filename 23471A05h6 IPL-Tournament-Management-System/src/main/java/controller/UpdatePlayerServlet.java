package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Playerbean;
import dao.PlayerDAO;

@WebServlet("/updatePlayer")
public class UpdatePlayerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Playerbean player = new Playerbean();

        player.setPlayerId(
                Integer.parseInt(request.getParameter("playerId")));

        player.setPlayerName(
                request.getParameter("playerName"));

        player.setRole(
                request.getParameter("role"));

        player.setTeamId(
                Integer.parseInt(request.getParameter("teamId")));

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.updatePlayer(player);

        if (status) {

            response.sendRedirect("viewPlayers.jsp");

        } else {

            response.sendRedirect(
                    "editPlayer.jsp?id=" + player.getPlayerId());
        }
    }
}