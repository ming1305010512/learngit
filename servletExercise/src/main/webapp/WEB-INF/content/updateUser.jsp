<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/11
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>跟新用户页面</title>
    <link href="css/updateUser.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="content">
    <div id="update">
        <h3>信息更改</h3>
        <form action="userServlet?type=update&userId=${requestScope.user.id}" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName" size="20" value="${requestScope.user.userName}" placeholder="${requestScope.user.userName}"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" size="20" value="${requestScope.user.password}" placeholder="${requestScope.user.password}"></td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" name="nickname" size="20" value="${requestScope.user.nickname}" placeholder="${requestScope.user.nickname}"></td>
            </tr>
            <tr>
                <td>头像：</td>
                <td><img src="uploadFile/${requestScope.user.headPicture}"></td>
            </tr>
            <tr>
                <td>头像更改：</td>
                <td><input type="file" name="headPicture" value="${requestScope.user.headPicture}"></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="text" name="birthday" placeholder="<fmt:formatDate value="${requestScope.user.birthday}" type="date"></fmt:formatDate>" value="${requestScope.user.birthday}"> </td>
            </tr>
            <tr><td colspan="2" align="right"><input type="submit" value="更新"></td></tr>
        </table>
        </form>
    </div>
</div>
</body>
</html>
