package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}