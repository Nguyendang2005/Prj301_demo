package controller;

import model.Quiz;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

public class MathQuizServlet extends HttpServlet {
    private Random rnd = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int a = rnd.nextInt(10) + 1;
        int b = rnd.nextInt(10) + 1;
        String[] ops = {"+","-","*","/"};
        String op = ops[rnd.nextInt(ops.length)];
        Quiz q = new Quiz(a, b, op);
        req.getSession().setAttribute("currentQuiz", q);
        req.getRequestDispatcher("/WEB-INF/views/quiz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String ans = req.getParameter("answer");
        Quiz q = (Quiz) req.getSession().getAttribute("currentQuiz");
        boolean correct = false;
        if (q != null && ans != null) {
            try {
                double user = Double.parseDouble(ans);
                double real = q.getAnswer();
                correct = Math.abs(user - real) < 1e-6;
            } catch (Exception e) {}
        }
        req.setAttribute("correct", correct);
        req.getRequestDispatcher("/WEB-INF/views/quiz.jsp").forward(req, resp);
    }
}