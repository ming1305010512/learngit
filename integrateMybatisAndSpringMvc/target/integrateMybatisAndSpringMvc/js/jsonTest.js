$(document).ready(function () {

    $("#requestJson").click(function () {
        alert("进来了")
    });

});

function requestJson() {
    alert("进来了")
    // $.ajax({
    //     type:'post',
    //     url:'/requestJson',
    //     contentType:'application/json;charset=utf-8',
    //     data:'{"itemName":"手机","itemPrice":999}',
    //     success:function (data) {
    //         alert(data)
    //     }
    // });
}

function responseJson() {

}

function check() {
    alert("click")
}