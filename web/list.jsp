<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/10/5
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <form action="/CustomerServlet?method=findAll" method="post" >
        <table style="margin-right: auto;margin-left: auto;text-align: center" border="1" cellspacing="0">
            <tr>
                <td>客户姓名</td>
                <td>性别</td>
                <td>生日</td>
                <td>手机</td>
                <td>邮箱</td>
                <td>描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.customersList}" var="customer">
                <tr>
                    <td>${customer.cname}</td>
                    <td>
                        <c:if test="${customer['gender'] eq 'man'}">男</c:if>
                        <c:if test="${customer.gender eq 'woman'}">女</c:if>
                    </td>
                    <td>${customer.birthday}</td>
                    <td>${customer.cellphone}</td>
                    <td>${customer.email}</td>
                    <td>${customer.description}</td>
                    <td>
                        <a href="<c:url value="/CustomerServlet?method=preEditCustomer&cid=${customer.cid}"/>">编辑</a>
                        <a href="<c:url value="/CustomerServlet?method=deleteCustomer&cid=${customer.cid}"/>">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="submit" value="刷新"  name="submit">
    </form>
</div>

</body>
</html>
