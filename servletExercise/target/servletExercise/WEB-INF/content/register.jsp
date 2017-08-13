<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/11
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div id="content" style="height: 400px;width: 600px;border:1px solid #c7ff2d;margin-left: 400px;">

    <h2>注册页面</h2><br>
    <form action="userServlet?type=insert" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" name="nickname"></td>
            </tr>
            <tr>
                <td>头像：</td>
                <td><input type="file" name="headPicture"></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="text" name="birthday"></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
