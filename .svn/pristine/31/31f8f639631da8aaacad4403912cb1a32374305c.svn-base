
//加载菜单
$.ajax({
    type: "POST",
    url: sys_menu_url.nav,
    success: function(result){
        if(result.code == 0){//成功
           loadMenu(result.menuList)
        }else{

        }
    },
    error:function(e){
    }
});

function loadMenu(data) {
    layui.use(["tree"], function() {
        layui.tree({
            elem: '.layui-side-scroll', //传入元素选择器
            nodes: data
        });

    })
}
