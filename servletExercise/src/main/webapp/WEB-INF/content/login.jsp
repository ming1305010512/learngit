<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/11
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<body>
    <div id="content">

        <div id="login">
            <h3>登陆页面</h3><br>
            <form action="pagingServlet" method="post">
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" name="userName"></td>
                    </tr>
                    <tr style="height: 10px">

                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr style="height: 20px">

                    </tr>
                    <tr>
                        <td><a href="transpondServlet?parameter=register" class="btn btn-info">注册</a></td>

                        <td colspan="2" align="right"><input type="submit" class="btn btn-info" value="登陆"></td>
                    </tr>
                    <tr style="height: 20px">

                    </tr>
                    <tr >
                        <td colspan="2" style="padding-left: 55px;"><span style="color: red;">${requestScope.message}</span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
