
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QuizServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String sx = req.getParameter("x");
        String sy = req.getParameter("y");
        String sans = req.getParameter("ans");
        
         try (PrintWriter out = resp.getWriter()) {
            int x = Integer.parseInt(sx);
            int y = Integer.parseInt(sy);
            int ans = Integer.parseInt(sans);

            int correct = x + y;
            if (ans == correct) {
                out.println("<h3 style='color:green'>Correct! " + x + " + " + y + " = " + correct + "</h3>");
            } else {
                out.println("<h3 style='color:red'>Wrong. " + x + " + " + y + " = " + correct + "</h3>");
            }
            out.println("<p><a href='quiz.jsp'>Play again</a> | <a href='index.html'>Home</a></p>");
        } catch (Exception ex) {
            resp.getWriter().println("<h3>Invalid input.</h3><a href='quiz.jsp'>Back</a>");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.sendRedirect("quiz.jsp");
    }

}
