<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/10/5
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base target="main">
</head>
<body style="text-align: center">
<h1>客户关系管理系统</h1>
<a href="<c:url value='/add.jsp'/> ">添加客户</a>
<a href="<c:url value="/CustomerServlet?method=findAll"/>">查询客户</a>
<a href="<c:url value='/query.jsp'/>">高级搜索</a>
</body>
</html>
