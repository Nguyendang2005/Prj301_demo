<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
    <body>
<h2>Calculator Result</h2>
<p>
<%= request.getAttribute("num1") %>
<%= request.getAttribute("op") %>
<%= request.getAttribute("num2") %>
=
<% if ((Boolean) request.getAttribute("resultValid")) { %>
<%= request.getAttribute("result") %>
<% } else { %>
<b>Invalid operation</b>
<% } %>
</p>
<a href="<%= request.getContextPath() %>/calculator.html">Back</a>
</body></html>