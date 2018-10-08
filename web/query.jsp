<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/10/5
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">

    <form action="/CustomerServlet" method="post">
        <%@include file="table.jsp"%>
        <input type="hidden" name="method" value="findCustomers">
        <input type="submit" name="submit" value="查询">
        <input type="reset" name="reset" value="重置">
    </form>
</div>

</body>
</html>
