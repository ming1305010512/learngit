<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/21
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
</head>
<%--${pageContext.request.contextPath}/js/jquery.js--%>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<%--<script type="text/javascript" src="js/jsonTest.js"/>--%>
<script>
    $(document).ready(function () {
        $('#requestJson').click(function () {
            alert("进来了")
            $.ajax("requestJson",{
                type:'post',
                dataType:'json',
                contentType:'application/json;charset=utf-8',
                data:'{"itemName":"手机","itemPrice":999}',
                success:function (data) {
                    alert(data.itemName)
                }
            });
        });

    });
    //请求key/value，输出json
    function responseJson() {
        $.ajax("responseJson",{
            type:'post',
            dataType:'json',
            //请求数据位key/value类型，是默认的，所以contentType不需要配置
            //默认的类型为：application/x-www-form-urlencoded; charset=UTF-8
//            contentType:'application/json;charset=utf-8',
            data:'itemName=手机&itemPrice=999',
            //data为返回的json对象
            success:function (data) {
                alert(data.itemName)
            }
        });
    }
</script>
<body>

<button id="requestJson">请求json，输出json</button>
<input type="button" onclick="responseJson()" value="请求key/value，输出json">
</body>
</html>
