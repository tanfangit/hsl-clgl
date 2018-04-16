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
        var	title;//弹出层主题
        if(type==0){
        }else if(type==1){
            title='编辑部门';
            //当前修改部门id
            var deptId=data.deptId;
            //上级部门名称
            var parentName=data.parentName;
            //暂存查询出来的上级部门id
            $("#selectParentDeptId").val(data.parentId);
            $.ajax({ //查询部门信息
                type: "POST",
                url:sys_dept_url.dept_selectone+deptId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
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
                        $("#confirmBox input[name=deptName]").val(r.sysDept.name);
                        $("#confirmBox input[name=deptOrder]").val(r.sysDept.orderNum);
                        $("#confirmBox input[name=parentdept]").val(parentName);
                        form.render();

                    }else{
                        layer.alert(r.msg);
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
                                                $("#confirmBox input[name=parentdept]").val(node.name);
                                                $("#selectParentDeptId").val(node.deptId);
                                                //选中节点，改变状态
                                                $("body").on("mousedown",".layui-tree a cite",function(){
                                                    $(".layui-tree a cite").css('color','#336699')
                                                    $(this).css('color','red')
                                                })

                                            }
                                        });
                                    });

                                }else{
                                    layer.msg(r.msg);
                                }

                            }
                        });

                    });

                }
            });

            //点击确定事件
            form.on('submit(sure)', function(data){
                var deptname=$("#confirmBox input[name=deptName]").val();
               var deptorder= $("#confirmBox input[name=deptOrder]").val();
                //选中的上级部门id
                var selectParentDeptId=$("#selectParentDeptId").val();
                var _jsonFilter={
                    deptId:deptId,
                    name:deptname,
                    orderNum: deptorder,
                    parentId:selectParentDeptId

                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改部门
                $.ajax({
                    type: "POST",
                    url:sys_dept_url.dept_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("修改部门信息成功",function () {
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


        }else if(type==2){//删除部门
            //选中用户部门id
            var deptId=data.deptId;
            $.ajax({ //删除部门
                type: "POST",
                url:sys_dept_url.dept_delete+deptId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除部门信息成功",function () {
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
            title='新增部门';
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
                                        $("#confirmBox input[name=parentdept]").val(node.name);
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

            //点击确定事件
            form.on('submit(sure)', function(data){
                var  deptName= $("#confirmBox input[name=deptName]").val();
                var  deptOrder= $("#confirmBox input[name=deptOrder]").val();
                var   parentDeptId=$("#selectDeptId").val();
                var _jsonFilter={
                    name:deptName,
                    orderNum: deptOrder,
                    parentId:parentDeptId
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);
                //新增部门
                $.ajax({
                    type: "POST",
                    url:sys_dept_url.dept_add,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增部门成功",function () {
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

        }

    }


    //点击搜索按钮
    form.on('submit(search)', function(data){
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        table.reload('demo', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });



    table.render({
        elem: '#demo',
        url:sys_dept_url.dept_list,
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
                    field: 'name',
                    title: '部门名称',
                    minWidth:150

                }, {
                field: 'parentName',
                title: '上级部门',
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
