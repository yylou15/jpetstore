window.onload = function (ev) {
    changeVerify  = function checkCode(obj) {
        obj.src = "VerifyCode?" + new Date().getTime();
    }
};