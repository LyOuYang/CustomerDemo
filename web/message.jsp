<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/10/5
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div style="text-align: center">
    <h2 style="color: red">${message}</h2>
    <h3 style="color: red">3秒后将调至详情页</h3>
    <%
        response.setHeader("refresh","3;url=/CustomerServlet?method=findAll");
    %>
</div>
</body>
</html>
