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

        if(!code){
            $('#SignInInfo').text("Please enter verify code");
            return;
        }
        if(!username){
            $('#SignInInfo').text("Please enter username!");
            return;
        }
        if(!password){
            $('#SignInInfo').text("Please enter password!");
            return;
        }

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
                    //res.data==true
                    window.location="main";
                }
            }
        })
    });

    $("#searchInput")
        .on("input propertychange",function (e) {
        let keyword = $(this).val();
        if(keyword){
            $.ajax({
                url: "searchAjax",
                type: "get",
                data: {
                    keyword:keyword
                },
                success:function (res) {
                    if(res !== "[]"){
                        res = res.substring(1,res.length-1);
                        let resArr = res.split(", ");
                        setItems(resArr)
                    }else{
                        $("#searchItem").hide();
                    }
                }
            })
        }else{
            $("#searchItem").hide();
        }

    })
        .blur(function () {
            //防止失去焦点隐藏 和 点击事件 冲突
            setTimeout(function () {
                $("#searchItem").hide();
            },100)
    });


    setItems = function (a) {
        $("#itemList").html("");
        for(let i in a){
            $("#itemList").append("<li class=\"list-group-item\" onclick=\"selectItem(this)\" >" + a[i] + "</li>");
            $("#searchItem").show();
        }
    };

    selectItem = function (target) {
        $("#searchInput").val(target.innerText);
    };

    // unselectItem = function () {
    //     $("#searchInput").val("");
    // }
});
