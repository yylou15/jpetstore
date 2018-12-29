// window.onload = function (ev) {
    // changeVerify  = function (obj) {
    //     obj.src = "VerifyCode?" + new Date().getTime();
    // };
    // submitInfo = function () {
    //     $.ajax({
    //         url:'www.baidu.com',
    //         success:function () {
    //             console.log(111)
    //         }
    //
    //     })
    // }
// };


$(document).ready(function () {
    changeVerify = function (obj) {
        obj.src = "VerifyCode?" + new Date().getTime();
    };

    $("#submitForm").click(function () {
        let username = $('#username').val();
        let password = $('#password').val();
        let code = $('#verify').val();

        $.ajax({
            url:'LoginAjax',
            //访问的是LoginAjaxServlet
            type: "post",
            data:{
                username: username,
                password: password,
                code: code
            },
            success:function (res) {
                console.log(res);
                res = JSON.parse(res);
                if(res.status === false){
                    $('#SignInInfo').text(res.msg);
                }else{
                    //res.data=='true'
                    window.location="main";
                }
            }
        })
    });

});
