
layui.use(["layer"],function(){
    var layer=layui.layer;
    document.getElementById("loginBtn").addEventListener("click",function(){
        var data = "username="+$("#username").val()+"&password="+$("#password").val();
        $.ajax({//ajax请求登录
            type: "POST",
            url: sys_login_url.sys_login,
            data: data,
            dataType: "json",
            success: function(result){
                if(result.code == 0){//登录成功
                    parent.location.href ='index.html';
                }else{//登录失败
                    layer.msg(result.msg)
                }
            },
            error:function(e){
                console.log(e);
            }
        });

    })
})