<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/10/5
  Time: 17:07
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
        <input type="hidden" name="method" value="addCustomer">
        <%--<jsp:include page="table.jsp"></jsp:include>--%>
        <%@include file="table.jsp"%>
        <input type="submit" name="addSubmit" value="添加用户">
        <input type="reset"  name="reButton" value="重置">
    </form>
</div>

</body>
</html>
