/**
 * Created by zhangqiao on 2018/3/26.
 */

layui.use(["element", "form", "table", "laydate"], function() {
    element = layui.element,
        table = layui.table,
        form = layui.form,
        laydate = layui.laydate;
    laydate.render({
        elem: '#beginTime',
        type: "date"
    });
    laydate.render({
        elem: '#endTime',
        type: "date"
    })

    form.render();

    table.on('tool(roleTable)', function(obj) {
        var data = obj.data;
       if(obj.event === 'edit') {//编辑
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data)//传值为1时是编辑操作，需要传送行数据用来更新表单
        }else if(obj.event === 'del'){//删除
            layer.confirm("确定删除记改录？", {
                btn : [ '确定', '取消' ]//按钮
            }, function(index) {
                layer.close(index);
                fn_supplierOperate(2,data)
               // var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
            });
           // fn_supplierOperate(2,data)
        }


    });

   //点击新增用户
    $("#insertUserButton").click(function(){
        fn_supplierOperate(3)
    });


    function fn_supplierOperate(type,data){
        console.log(data);
        var	title;//弹出层主题
        if(type==1){
            title='编辑角色';
            //选中的角色id
            var roleId=data.roleId;
            $.ajax({ //查询角色信息
                type: "POST",
                url:sys_role_url.role_select+roleId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        console.log(r.role);
                        layer.open({
                            type: 1,
                            shade: 0.8,
                            title: title,
                            area: ["500px", "550px"],
                            end: function () {//重新加载
                                window.parent.location.reload();
                            },
                            content: $('#infoBox')//注意：这里不用加.html，否则弹框取不到值
                        });
                        $("#confirmBox input[name=rolename]").val(r.role.roleName);
                        $("#confirmBox input[name=remark]").val(r.role.remark);
                        var _jsonFilter={
                            menusdList:r.role.menusdList,
                        };
                        var formatedata =JSON.stringify(_jsonFilter);
                        $.ajax({//加载权限菜单树
                            type: "POST",
                            contentType: "application/json",
                            data: formatedata,
                            url:sys_menu_url.menu_selectTree,
                            success: function(data) {
                                if(data.code==0){
                                    var xtree2 = new layuiXtree({
                                        elem: 'xtree2'                  //(必填) 放置xtree的容器，样式参照 .xtree_contianer
                                        , form: form                    //(必填) layui 的 from
                                        , data: data.menusTree //(必填) 数据接口，需要返回以上结构的json字符串
                                    });
                                    form.render();

                                    //点击确定事件
                                    form.on('submit(sure)', function(data){
                                        //获取选中val
                                        var oCks = xtree2.GetChecked();
                                        var arrMenus=[];
                                        for (var i = 0; i < oCks.length; i++) {
                                            arrMenus.push(oCks[i].value);
                                        }
                                        console.log(arrMenus);
                                        var roleName=$("#confirmBox input[name=rolename]").val();
                                        var remark=$("#confirmBox input[name=remark]").val();
                                        var _jsonFilter={
                                            roleId:roleId,
                                            roleName: roleName,
                                            remark:remark,
                                            menusdList:arrMenus
                                        };
                                        var formatedata =JSON.stringify(_jsonFilter);
                                        console.log(formatedata);
                                        //修改角色
                                        $.ajax({
                                            type: "POST",
                                            url:sys_role_url.role_update,
                                            contentType: "application/json",
                                            data: formatedata,
                                            success: function(r){
                                                if(r.code == 0){
                                                    layer.alert("修改角色成功",function () {
                                                        window.parent.location.reload();
                                                        parent.layer.close();
                                                    });
                                                }else{
                                                    layer.msg(r.msg,function () {
                                                        window.parent.location.reload();
                                                        parent.layer.close();
                                                    });
                                                }
                                            }
                                        });
                                        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                                    });





                                }else{

                                }

                            }
                        });

                    }else{
                        // alert(r.msg);
                    }

                }
            });



        }else if(type==2){//删除角色
            //选中的角色id
            var roleId=data.roleId;
            $.ajax({ //删除角色
                type: "POST",
                url:sys_role_url.role_delete+roleId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除角色成功",function () {
                            window.parent.location.reload();
                            parent.layer.close();
                        });
                    }else{
                        layer.msg(r.msg,function () {
                            window.parent.location.reload();
                            parent.layer.close();
                        });
                    }
                }
            });

        }else if(type==3){
            title='新增角色';

            $.ajax({//请求所有菜单树
                type:'POST',
                contentType: "application/json",
                url:sys_menu_url.menu_tree,
                success: function(data) {
                    console.log(data.menusTree)
                    if(data.code==0){
                        var index=layer.open({
                            type: 1,
                            shade: 0.8,
                            title: title,
                            area: ["500px", "550px"],
                            end: function () {//重新加载
                                window.parent.location.reload();
                            },
                            content: $('#infoBox')//注意：这里不用加.html，否则弹框取不到值
                        });

                        var xtree2 = new layuiXtree({
                            elem: 'xtree2'                  //(必填) 放置xtree的容器，样式参照 .xtree_contianer
                            , form: form                    //(必填) layui 的 from
                            , data: data.menusTree //(必填) 数据接口，需要返回以上结构的json字符串
                        });
                        form.render();
                        var menusStr="";
                        form.on('submit(sure)', function(data){
                            //获取选中val
                                var oCks = xtree2.GetChecked();
                                var arrMenus=[];
                                for (var i = 0; i < oCks.length; i++) {
                                    arrMenus.push(oCks[i].value);
                                }
                            console.log(arrMenus);
                            var roleName=$("#confirmBox input[name=rolename]").val();
                            var remark=$("#confirmBox input[name=remark]").val();
                            var _jsonFilter={
                                roleName: roleName,
                                remark:remark,
                                menusdList:arrMenus
                            };
                            var formatedata =JSON.stringify(_jsonFilter);
                            console.log(formatedata);
                            //新增角色
                            $.ajax({
                                type: "POST",
                                url:sys_role_url.role_save,
                                contentType: "application/json",
                                data: formatedata,
                                success: function(r){
                                    if(r.code == 0){
                                        layer.alert("新增角色成功",function () {
                                            window.parent.location.reload();
                                            parent.layer.close();
                                        });
                                    }else{
                                        layer.msg(r.msg,function () {
                                            window.parent.location.reload();
                                            parent.layer.close();
                                        });
                                        // alert(r.msg);
                                    }
                                }
                            });


                               });

                    }else{

                    }

                }
            });


        }


    }


    //点击搜索按钮
    form.on('submit(search)', function(data){

        //console.log(data.elem) //被执行search事件的元素DOM对象，一般为button对象
        // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        table.reload('roleTable', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });


    table.render({
        elem: '#roleTable',
        url:sys_role_url.role_list,
        height: 485,
        response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 0 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'total' //数据总数的字段名称，默认：count
            ,dataName: 'rows' //数据列表的字段名称，默认：data
        },
        cols: [
            [ //标题栏
                // {checkbox: true, LAY_CHECKED: true}, //默认全选
                {
                    field: 'roleName',
                    title: '角色名',
                    minWidth:150

                }, {
                field: 'remark',
                title: '角色描述',
                minWidth:150

            }, {
                field: 'createTime',
                title: '创建时间',
                minWidth:150

            }, {
                fixed: 'right',
                title: "操作",
                width: 250,
                align: 'center',
                toolbar: '#barDemo'
            }
            ]
        ],
        skin: 'row',
        even: true,
        page: true,
        limits: [10 ,20, 40,80]
    });

})
