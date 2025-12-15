<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Quiz" %>
<%
Quiz q = (Quiz) session.getAttribute("currentQuiz");
Boolean correct = (Boolean) request.getAttribute("correct");
%>
<html><body>
<h2>Math Quiz</h2>
<% if (q == null) { %>
<form action="<%= request.getContextPath() %>/math-quiz" method="get">
<input type="submit" value="Start Quiz">
<head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
</form>

<% } else { %>
<p>Solve: <b><%= q.getA() %> <%= q.getOp() %> <%= q.getB() %></b></p>
<form action="<%= request.getContextPath() %>/math-quiz" method="post">
<input name="answer" placeholder="Your answer">
<input type="submit" value="Submit">
</form>
<% if (correct != null) { %>
<p>
<% if (correct) { %>
<span style="color:green">Correct!</span>
<% } else { %>
<span style="color:red">Incorrect. Real answer: <%= q.getAnswer() %></span>
<% } %>
</p>
<form action="<%= request.getContextPath() %>/math-quiz" method="get">
<input type="submit" value="Next question">
</form>
<% } %>
<% } %>
</body></html>