

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    // tạo random số và xuất form gửi đến /quiz (GET để hiện câu, POST để kiểm tra)
    int x=(int)(Math.random()*10)+1;
    int y=(int)(Math.random()*10)+1;
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math quiz</title>
    </head>
    <body>
        <h2>Math Quiz</h2>
        <form action="quiz" method="post">
        <p><%= x %> + <%= y %> = ?</p>
        <input type="hidden" name="x" value="<%= x %>">
        <input type="hidden" name="y" value="<%= y %>">
        <input type="number" name="ans" required>
        <input type="submit" value="Submit">
    </form>
    <p><a href="index.html">Home</a></p>
    </body>
</html>
