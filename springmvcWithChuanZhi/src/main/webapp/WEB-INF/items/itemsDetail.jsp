<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/10
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品信息页面</title>
</head>
<body>
    <table width="100%">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>描述</td>
        </tr>
       <c:forEach items="${itemsList}" var="item">
           <tr>
               <td>${item.name}</td>
               <td>${item.price}</td>
               <td>${item.detail}</td>
           </tr>
       </c:forEach>
    </table>
</body>
</html>
