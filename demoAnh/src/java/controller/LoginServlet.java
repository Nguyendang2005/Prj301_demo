package controller;

import model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String u = request.getParameter("user");
        String p = request.getParameter("password");

        if (User.authenticate(u, p)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", u);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h3>Login incorrect!</h3>");
            out.println("<a href=\"login.html\">Back to login</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}