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

    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {//查看
            fn_supplierOperate(0,data)
            // layer.msg('ID：' + data.id + ' 的查看操作');
        } else if(obj.event === 'edit') {//编辑
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

        $("#rolesID").html("");//清空下拉选
        var	title;//弹出层主题
        if(type==0){
            title='查看用户';
            var jsonFilter={
                userId:data.userId
            };
            var formatedata =JSON.stringify(jsonFilter);
            console.log(formatedata);
            $.ajax({ //查询用户信息
                type: "POST",
                url:sys_user_url.user_selectone+data.userId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        console.log(r.user);
                        var index=layer.open({
                            type: 1,
                            shade: 0.8,
                            title: title, //不显示标题
                            area: ["500px", "550px"],
                            end: function () {//重新加载
                                window.parent.location.reload();
                            },
                            content: $('#userInfo')//注意：这里不用加.html，否则弹框取不到值
                        });
                        $("#userInfoConfirm input[name=infoName]").val(r.user.name);
                        $("#userInfoConfirm input[name=InfoMobile]").val(r.user.mobile);
                        $("#userInfoConfirm input[name=InfoDept]").val(r.user.deptName);
                        $("#userInfoConfirm input[name=InfoPosition]").val(r.user.userPosition);
                        $("#userInfoConfirm input[name=InfoWorkYear]").val(r.user.workYear);
                        form.render();
                    }else{
                        // alert(r.msg);
                    }
                }
            });
            //查看详情 确定事件
            form.on('submit(InfoSure)', function(data){
                window.parent.location.reload();
                parent.layer.close();
            });

        }else if(type==1){
            title='编辑用户';
            //当前修改的用户id
            var userID=data.userId;
            //当前修改用户的部门id
            var deptID=data.dept;
            $("#selectDeptId").val(deptID);
            //当前修改用户的盐
            var salt=data.salt;
            $.ajax({ //查询用户信息
                type: "POST",
                url:sys_user_url.user_selectone+userID,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        console.log(r.user);
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
                        $("#confirmBox input[name=username1]").val(r.user.username);
                        $("#confirmBox input[name=password]").val("");
                        $("#confirmBox input[name=name]").val(r.user.name);
                        $("#confirmBox input[name=mobile]").val(r.user.mobile);
                        $("#confirmBox input[name=dept]").val(r.user.deptName);
                        $("#confirmBox input[name=job]").val(r.user.userPosition);
                        $("#confirmBox input[name=workLife]").val(r.user.workYear);
                        $("#confirmBox input[name=email]").val(r.user.email);
                        //显示用户已经拥有的角色
                        var rolesArr=[];
                        var obj=r.user.roleIdList;
                        for(var i=0,len=obj.length; i<len; i++){
                            rolesArr.push(obj[i]);
                        }
                        rolesArr.push(rolesArr);

                        $.ajax({//发送请求加载角色下拉选
                            type:'POST',
                            dataType:'json',
                            url:sys_role_url.role_roles,
                            success: function(data) {
                                if(data.code==0){
                                    $("#rolesID").append('<option value="">' + "请选择" + '</option>');
                                    $.each(data.roles,function(key,values){
                                        $("#rolesID").append('<option value="'+values.roleId +'">'+ values.roleName + '</option>');
                                    });
                                    //显示用户拥有的角色
                                    $('select[name="role"]').val(rolesArr);
                                   form.render();
                                }else{

                                }

                            }
                        })

                        form.render();

                    }else{
                        // alert(r.msg);
                    }


                    //加载部门树
                    //部门输入框监听事件
                    document.getElementById("dept").addEventListener("click",function(){
                        $("#depts").html("");//清空
                        $.ajax({//请求加载部门树
                            type:'POST',
                            contentType: "application/json",
                            url:sys_dept_url.dept_tree,
                            success: function(data) {
                                if(data.code==0){
                                    layer.open({
                                        type: 1,
                                        shade: 0.8,
                                        btn: ['确定'],
                                        btnAlign: 'c',
                                        title: '选择部门',
                                        area: ["300px", "400px"],
                                        content: $('#deptList')//注意：这里不用加.html，否则弹框取不到值
                                    });

                                    layui.use('tree', function(){
                                        layui.tree({//加载部门树结构
                                            elem: '#depts'
                                            ,nodes:data.depts
                                            ,click: function(node){
                                                console.log(node) //node即为当前点击的节点数据
                                                //赋值到输入框
                                                $("#confirmBox input[name=dept]").val(node.name);
                                                $("#selectDeptId").val(node.deptId);
                                                //选中节点，改变状态
                                                $("body").on("mousedown",".layui-tree a cite",function(){
                                                    $(".layui-tree a cite").css('color','#336699')
                                                    $(this).css('color','red')
                                                })

                                            }
                                        });
                                    });

                                }

                            }
                        });

                    });

                }
            });

            //点击确定事件
            form.on('submit(sure)', function(data){
                var  username1= $("#confirmBox input[name=username1]").val();
                var  name= $("#confirmBox input[name=name]").val();
                var  mobile= $("#confirmBox input[name=mobile]").val();
                var password=$("#confirmBox input[name=password]").val();
                // 获取选中的角色
                var roles=$('select[name="role"]').val();
                var  job=$("#confirmBox input[name=job]").val();
                var  workLife=$("#confirmBox input[name=workLife]").val();
                var  email=$("#confirmBox input[name=email]").val();
                var selectDeptId=$("#selectDeptId").val();

                var _jsonFilter={
                    userId:userID,
                    username:username1,
                    salt:salt,
                    name: name,
                    mobile:mobile,
                    email:email,
                    password:password,
                    workYear:workLife,
                    userPosition:job,
                    dept:selectDeptId,
                    roleIdList:roles
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改用户
                $.ajax({
                    type: "POST",
                    url:sys_user_url.user_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("修改用户成功",function () {
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

            //监听下拉选 获取下拉选角色值
            form.on('select(category)', function(data){
                roleID = data.value;
                $("#temp").val(roleID);
                form.render('select')
            });

        }else if(type==2){
            $.ajax({ //删除用户
                type: "POST",
                url:sys_user_url.user_delete+data.userId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除用户成功",function () {
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
            title='新增用户';
            $.ajax({//发送请求加载角色下拉选
                type:'POST',
                dataType:'json',
                url:sys_role_url.role_roles,
                success: function(data) {
                    if(data.code==0){
                        $("#rolesID").append('<option value="">' + "请选择" + '</option>');
                        $.each(data.roles,function(key,values){
                            $("#rolesID").append('<option value="'+values.roleId +'">'+ values.roleName + '</option>');
                        });

                        var index=layer.open({
                            type: 1,
                            shade: 0.8,
                            title: title, //不显示标题
                            area: ["500px", "550px"],
                            end: function () {//重新加载
                                window.parent.location.reload();
                            },
                            content: $('#infoBox')//注意：这里不用加.html，否则弹框取不到值
                        });
                        form.render();

                    }

                }
            });

            //清空
            $("#confirmBox input,#confirmBox select").val("")

            //部门输入框监听事件
            document.getElementById("dept").addEventListener("click",function(){
                $("#depts").html("");//清空
                $.ajax({//请求加载部门树
                    type:'POST',
                    contentType: "application/json",
                    url:sys_dept_url.dept_tree,
                    success: function(data) {
                        if(data.code==0){
                            layer.open({
                                type: 1,
                                shade: 0.8,
                                btn: ['确定'],
                                btnAlign: 'c',
                                title: '选择部门',
                                area: ["300px", "400px"],
                                content: $('#deptList')//注意：这里不用加.html，否则弹框取不到值
                            });

                            layui.use('tree', function(){
                                layui.tree({//加载部门树结构
                                    elem: '#depts'
                                    ,nodes:data.depts
                                    ,click: function(node){
                                        console.log(node) //node即为当前点击的节点数据
                                        //赋值到输入框
                                        $("#confirmBox input[name=dept]").val(node.name);
                                        $("#selectDeptId").val(node.deptId);
                                        //选中节点，改变状态
                                        $("body").on("mousedown",".layui-tree a cite",function(){
                                            $(".layui-tree a cite").css('color','#336699')
                                            $(this).css('color','red')
                                        })

                                        //parent.layer.close();
                                    }
                                });
                            });

                        }

                    }
                });


            });

            //监听下拉选 获取下拉选角色值
            form.on('select(category)', function(data){
                roleID = data.value;
                $("#temp").val(roleID);
                form.render('select')
            });

            //点击确定事件
            form.on('submit(sure)', function(data){
                var  username1= $("#confirmBox input[name=username1]").val();
                var  name= $("#confirmBox input[name=name]").val();
                var  mobile= $("#confirmBox input[name=mobile]").val();
                var password=$("#confirmBox input[name=password]").val();
                // 获取选中的角色
                var roles=$('select[name="role"]').val();
               var email=$("#confirmBox input[name=email]").val();
                var  job=$("#confirmBox input[name=job]").val();
                var  workLife=$("#confirmBox input[name=workLife]").val();
                var selectDeptId=$("#selectDeptId").val();
                var _jsonFilter={
                    username:username1,
                    name: name,
                    mobile:mobile,
                    email:email,
                    password:password,
                    workYear:workLife,
                    userPosition:job,
                    dept:selectDeptId,
                    roleIdList:roles
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);
                //新增用户
                $.ajax({
                    type: "POST",
                    url:sys_user_url.user_add,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增用户成功",function () {
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
                // console.log(data.elem) //被执行search事件的元素DOM对象，一般为button对象
                //console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
                // console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                //table.reload('demo', {
                //  where:data.field
                // });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });

        }



    }


    //点击搜索按钮
    form.on('submit(search)', function(data){
        //console.log(data.elem) //被执行search事件的元素DOM对象，一般为button对象
        // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        table.reload('demo', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });



    table.render({
        elem: '#demo',
        url:sys_user_url.user_list,
        height: 'full-200',
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
                    field: 'username',
                    title: '用户名',
                    minWidth:150

                }, {
                field: 'name',
                title: '姓名',
                minWidth:150

            }, {
                field: 'mobile',
                title: '电话号码',
                minWidth:150

            }, {
                field: 'email',
                title: '邮箱',
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
