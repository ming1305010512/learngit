<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/19
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名：${requestScope.user.name}
密码：${requestScope.user.password}
</body>
</html>
