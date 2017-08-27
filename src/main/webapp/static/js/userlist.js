/**
 * Created by 俊 on 2017/7/9.
 */
$(function(){
    $.ajax({
        type:"GET",
        headers:{
            'Content-Type': "application/json; charset=utf-8"
        },
        url:"/rest/user/getUserList",
        //data:{userName:uservalue,passWord:passvalue},
        success: function(msg){
            red(msg)
            //debugger
        }
    })

    function red( array) {
        var tableu=$("table");
        for(var i=0;i<array.length;i++){
            tableu.append('<tr><td>'+array[i].userName+'</td><td>'+array[i].passWord+'</td></tr>')
        }
    }
})
