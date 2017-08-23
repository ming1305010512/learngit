<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/21
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>批量商品编辑页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/items/editeAllItemsSubmit" method="post" id="form1">
    <table width="100%">
        <tr>
            <td colspan="2">商品查询</td>
        </tr>
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="itemCustom.itemName"></td>
        </tr>
        <tr>
            <td colspan="2"><button  id="query">商品查询</button></td>
            <%--<td><button id="delete">批量删除</button></td>--%>
            <td><input type="submit" value="批量删除"></td>
        </tr>
        <tr>
            <td>
                上下文：${pageContext.request.contextPath}
            </td>
        </tr>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>描述</td>
        </tr>
        <%--<c:forEach items="${itemsList}" var="item" varStatus="status">--%>
            <%--<tr>--%>
                <%--<td><input type="text" name="itemsList[${status.index}].itemName" value="${item.itemName}"></td>--%>
                <%--<td><input type="text" name="itemsList[${status.index}].itemPrice" value="${item.itemPrice}"></td>--%>
                <%--<td><input type="text" name="itemsList[${status.index}].itemDetail" value="${item.itemDetail}"></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <c:forEach items="${itemsList}" var="item" varStatus="status">
            <tr>
                <td><input type="text" name="itemsMap['itemName'].itemName" value="${item.itemName}"></td>
                <td><input type="text" name="itemsMap['itemPrice'].itemPrice" value="${item.itemPrice}"></td>
                <td><input type="text" name="itemsMap['itemDetail'].itemDetail" value="${item.itemDetail}"></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" align="right">
            <input type="submit" value="批量修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
