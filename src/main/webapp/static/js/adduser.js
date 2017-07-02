/**
 * Created by 俊 on 2017/7/2.
 */
$(function () {
    var username=$(".username");
    var password=$(".password")
    var log_btn=$(".log_btn")
    log_btn.click(function () {
        var uservalue=username.val()
        var passvalue=password.val()
        debugger
        $.ajax({
            type: "POST",
            url: "/rest/user/add",
            data: {username:uservalue,password:passvalue},
            success: function(msg){
                debugger
            }
        })
        })
})