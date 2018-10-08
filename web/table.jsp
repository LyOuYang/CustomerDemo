<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table style="margin-right: auto;margin-left: auto;" >
    <tr>
        <td> 客户名称&emsp;&emsp;</td>
        <td><input type="text" name="cname" ></td>
    </tr>

    <tr style="text-align: center">
        <td> 客户姓别&emsp;&emsp;</td>
        <td><input  type="radio" name="gender" value="man" <c:if test="${customer['gender'] eq 'man'}">checked="checked"</c:if>> 男
            <input type="radio" name="gender" value="woman"<c:if test="${customer['gender'] eq 'woman'}">checked="checked"</c:if>>女
        </td>
    </tr>

    <tr>
        <td> &emsp;&emsp;手机&emsp;&emsp;</td>
        <td><input type="text" name="cellphone" value="${customer['cellphone']}"></td>
    </tr>

    <tr>
        <td> &emsp;&emsp;邮箱&emsp;&emsp;</td>
        <td><input type="text" name="email" value="${customer['email']}"></td>
    </tr>

    <tr>
        <td> &emsp;&emsp;描述&emsp;&emsp;</td>
        <td><input type="text" name="description" value="${customer['description']}"></td>
    </tr>
    ${customer['cname']}
    ${cusomer.cname}
</table>