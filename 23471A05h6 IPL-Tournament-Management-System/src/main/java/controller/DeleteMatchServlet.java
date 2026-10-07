package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.matchDAO;

@WebServlet("/deleteMatch")
public class DeleteMatchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int matchId = Integer.parseInt(request.getParameter("id"));

        matchDAO dao = new matchDAO();

        if (dao.deleteMatch(matchId)) {
            response.sendRedirect("viewMatches.jsp");
        } else {
            response.sendRedirect("viewMatches.jsp");
        }
    }
}