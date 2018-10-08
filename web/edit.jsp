<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <form action="/CustomerServlet"  style="text-align:center;">
        <input type="hidden" name="method" value="editCustomer">
        <input type="hidden" name="cid" value="${customer['cid']}">
        <%@include file="table.jsp"%>
        <br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
