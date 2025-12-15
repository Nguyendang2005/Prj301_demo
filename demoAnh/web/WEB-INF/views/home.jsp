<%@ page contentType="text/html;charset=UTF-8" %>
<%
String user = (String) session.getAttribute("username");
%>
<html>
    <head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
    
    <body>
<h1>Home</h1>
<p>Welcome, <b><%= user %></b></p>
<ul>
<li><a href="<%= request.getContextPath() %>/calculator.html">Calculator</a></li>
<li><a href="<%= request.getContextPath() %>/math-quiz">Math Quiz</a></li>
<li><a href="<%= request.getContextPath() %>/index.html">Index</a></li>
</ul>
</body></html>