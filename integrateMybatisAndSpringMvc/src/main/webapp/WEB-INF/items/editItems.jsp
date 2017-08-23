<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/19
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品修改页面</title>
</head>
<body>
    <form action="/items/editItemsSubmit" method="post" enctype="multipart/form-data">
        <table>
            错误提示信息:
            <c:if test="${allErrors!=null}">
            <c:forEach items="${allErrors}" var="error">
                <tr>
                    <td>${error.defaultMessage}</td>
                </tr>
            </c:forEach>
            </c:if>
            <tr>
                <td><input type="hidden" name="id" value="${item.id}"></td>
            </tr>
            <tr>
                <td>商品名称：</td>
                <td><input type="text" value="${item.itemName}" name="itemName"></td>
            </tr>
            <tr>
                <td>商品价格：</td>
                <td><input type="text" value="${item.itemPrice}" name="itemPrice"></td>
            </tr>
            <tr>
                <td>商品细节：</td>
                <td><input type="text" value="${item.itemDetail}" name="itemDetail"></td>
            </tr>
            <tr>
                <td>
                    商品图片：
                </td>
                <td>
                        <img src="/uploadFile/${item.picture}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="file" name="items_pic" >
                </td>
            </tr>
            <tr>
                <td>创建日期:</td>
                <td><input type="text" name="createtime" ></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
