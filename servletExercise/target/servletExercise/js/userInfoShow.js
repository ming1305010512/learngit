$(document).ready(function () {
   $("#button").click(function () {
       alert("进来了")
      $.ajax("ajaxServlet",{
          type:"post",
          dataType:"json",
          data:{"name":"longming","birthday":"2017-12-12"},
          complete: function(data,responseText,three){
              // var datastr=eval(data);
              //data为服务器返回的json对象
              alert(data.responseJSON.userName);
              //第二个参数表示状态
              alert(responseText)
              alert(three)
          }
      })
   });
});