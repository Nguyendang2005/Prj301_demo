package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
        String op = request.getParameter("op");

        double a = 0, b = 0;
        try {
            a = Double.parseDouble(s1);
            b = Double.parseDouble(s2);
        } catch (Exception e) {}

        double res = 0;
        boolean valid = true;

        switch(op){
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/":
                if (b == 0) valid = false;
                else res = a / b;
                break;
            default: valid = false;
        }

        request.setAttribute("resultValid", valid);
        request.setAttribute("result", res);
        request.setAttribute("num1", s1);
        request.setAttribute("num2", s2);
        request.setAttribute("op", op);
        request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
    }
}