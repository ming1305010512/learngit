<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/11
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>用户信息页面</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/userInfoShow.css" type="text/css">
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/userInfoShow.js"></script>
<script>
    check(){
        ${sessionScope.userId}
    }
</script>
<body style="width: 100%">

    <div id="top">

        <div id="table_top">
            <table border="0">
                <tr>
                    <c:choose>
                        <c:when test="${sessionScope.userName!=null}">
                            <td>欢迎&nbsp;${sessionScope.userName}</td>&nbsp;
                            <td><a href="existServlet" style="color: black">退出登录</a></td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <a href="transpondServlet?type=register">注册</a>
                            </td>
                            <td>
                                <a href="transpondServlet?type=login">登录</a>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
<%--
            <ul class="nav nav-pills nav-stacked">
                <li></li>
            </ul>--%>
        </div>
        <div class="col-md-8">
            <div id="userInfo">
                <table width="400px" class="table table-striped table-hover" >
                    <tr>
                        <td>用户名</td>
                        <td>昵称</td>
                        <td>头像</td>
                        <td>生日</td>
                        <td colspan="2" >操作</td>
                    </tr>
                    <c:forEach items="${requestScope.pageBean.pageUser}" var="user" >
                        <tr class="info">
                            <td>${user.userName}</td>
                            <td>${user.nickname}</td>
                            <td><img src="uploadFile/${user.headPicture}"></td>
                            <td>${user.birthday}</td>
                                <%--WEB-INF/content/updateUser.jsp--%>
                            <td><a href="userServlet?type=getUserOne&userId=${user.id}">更新</a></td>
                            <td><a href="userServlet?type=delete&userId=${user.id}" onclick="check()">删除</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="3"></td>
                        <td colspan="3">
                            <span>当前页：${requestScope.pageBean.currentPage}</span>
                            &nbsp;
                            <span><a href="pagingServlet?currentPage=1">第一页</a></span>
                            &nbsp;
                            <span><a href="pagingServlet?currentPage=${requestScope.pageBean.currentPage-1}">上一页</a></span>
                            &nbsp;
                            <span><a href="pagingServlet?currentPage=${requestScope.pageBean.currentPage+1}">下一页</a></span>
                            &nbsp;
                            <span><a href="pagingServlet?currentPage=${requestScope.pageBean.totalPage}">尾页</a></span>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button class="btn btn-info" id="button">显示当前用户信息</button>
                        </td>
                        <td colspan="5">

                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
