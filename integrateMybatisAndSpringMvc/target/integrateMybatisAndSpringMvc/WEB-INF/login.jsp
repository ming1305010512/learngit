<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
