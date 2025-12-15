
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String  user=req.getParameter("user");
       String  pass=req.getParameter("password");
     
       
       if(user!=null && pass!=null && user.equals("dang") && pass.equals("12345")){
           //login sucess
           req.getRequestDispatcher("welcome.jsp").forward(req, resp);
       }
       else{
           try(PrintWriter out=resp.getWriter()){
                out.println("<h3 style='color:red'>Login failed. Username/password incorrect.</h3>");
                out.println("<a href='login.jsp'>Try again</a>");
           }
       }
      
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("login.jsp");
    }
    

}
