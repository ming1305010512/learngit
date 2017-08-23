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
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $("#kkk").click(function () {
            alert("kkkk")
        })
//        $("#delete").click(function () {
//            alert("11111111")
//            $("#form1").attr("action","/items/delete");
//            alert($("#form1").attr("action"))
//            $("#form1").submit();
//        });
//        $("#query").click(function () {
//            alert("222222")
//            $("#form1").attr("action","/items/queryItems");
//            alert($("#form1").attr("action"))
//            $("#form1").submit()
//        });
    });
</script>
<body>

    用户名：${name}<br>
    <a href="/logout" >退出</a>
    <form action="/items/delete" method="post" id="form1">
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
            <td>选择</td>
            <td>名称</td>
            <td>价格</td>
            <td>描述</td>
        </tr>
       <c:forEach items="${itemsList}" var="item">
           <tr>
               <td><input type="checkbox" name="item_id" value="${item.id}"></td>
               <td>${item.itemName}</td>
               <td>${item.itemPrice}</td>
               <td>${item.itemDetail}</td>
               <td><a href="/items/editItems?id=${item.id}">修改</a> </td>
           </tr>
       </c:forEach>
    </table>
    </form>
</body>
</html>
