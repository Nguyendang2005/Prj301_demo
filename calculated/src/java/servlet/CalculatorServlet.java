
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculatorServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        
        String sa=req.getParameter("a");
        String sb=req.getParameter("b");
        String op=req.getParameter("op");
    try(PrintWriter out= resp.getWriter()){
        double a=Double.parseDouble(sa);
        double b= Double.parseDouble(sb);
        double res=0;
        boolean ok= true;
        switch(op){
              case "+": res = a + b; break;
              case "-": res = a - b; break;
              case "*": res = a * b; break;
                case "/":
                    if (b == 0) { ok = false; out.println("<h3>Cannot divide by zero.</h3>"); }
                    else res = a / b;
                    break;
                default: ok = false; out.println("<h3>Invalid operator.</h3>");
            }
        if(ok){
            out.println("<h3>Result: " + a + " " + op + " " + b + " = " + res + "</h3>");
        }
         out.println("<p><a href='calc.html'>Back</a> | <a href='index.html'>Home</a></p>");
        }catch(NumberFormatException ex){
              try (PrintWriter out = resp.getWriter()) {
                out.println("<h3>Invalid input. Please enter numbers.</h3>");
                out.println("<p><a href='calc.html'>Back</a></p>");
            }
        }
    }

    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("calc.html");
    }

}
