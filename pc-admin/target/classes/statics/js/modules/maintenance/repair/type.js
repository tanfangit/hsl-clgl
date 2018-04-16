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

    table.on('tool(repairType)', function(obj) {
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
            title='查看维修类别';
            //当前修改的维类别id
            var repairTypeId=data.repairTypeId;
            $.ajax({ //查询维修类别
                type: "POST",
                url:repair_type_url.type_info+repairTypeId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        var index=layer.open({
                            type: 1,
                            shade: 0.8,
                            title: title,
                            area: ["500px", "550px"],
                            end: function () {//重新加载
                                window.parent.location.reload();
                            },
                            content: $('#detailInfo')//注意：这里不用加.html，否则弹框取不到值
                        });
                        $("#detailConfirmBox input[name=repairypename]").val(r.repairType.repairTypeName);
                        $("#detailConfirmBox input[name=typeNo]").val(r.repairType.repairTypeNo);
                        $("#detailConfirmBox input[name=remark]").val(r.repairType.remark);
                        form.render();
                    }else{
                        layer.msg(r.msg);
                    }
                }
            });
            //查看详情 确定事件
            form.on('submit(detailSure)', function(data){
                window.parent.location.reload();
                parent.layer.close();
            });

        }else if(type==1){
            title='编辑维修类别';
            //当前修改的维类别id
            var repairTypeId=data.repairTypeId;
            $.ajax({ //查询维修类别信息
                type: "POST",
                url:repair_type_url.type_info+repairTypeId,
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
                        console.log(r.repairType)
                        $("#confirmBox input[name=repairypename]").val(r.repairType.repairTypeName);
                        $("#confirmBox input[name=remark]").val(r.repairType.remark);

                    }else{
                        layer.msg(r.msg);
                    }

                }
            });

            //修改维修类别-点击确定事件
            form.on('submit(sure)', function(data){
                var  repairypename=  $("#confirmBox input[name=repairypename]").val();
                var  remark=  $("#confirmBox input[name=remark]").val();
                var _jsonFilter={
                    repairTypeId:repairTypeId,
                    repairTypeName:repairypename,
                    remark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改维修类别
                $.ajax({
                    type: "POST",
                    url:repair_type_url.type_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("修改维修类别成功",function () {
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


        }else if(type==2){//删除维修类别
            //当前修改的维类别id
            var repairTypeId=data.repairTypeId;
            $.ajax({ //删除用户
                type: "POST",
                url:repair_type_url.type_delete+repairTypeId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除维修类别成功",function () {
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
            title='新增维修类别';
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

            //点击确定事件
            form.on('submit(sure)', function(data){
                var  repairypename= $("#confirmBox input[name=repairypename]").val();
                //var  typeNo= $("#confirmBox input[name=typeNo]").val();
                var  remark= $("#confirmBox input[name=remark]").val();
                var _jsonFilter={
                    repairTypeName:repairypename,
                  //  repairTypeNo: typeNo,
                    remark: remark

                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);
                //新增维修类别
                $.ajax({
                    type: "POST",
                    url:repair_type_url.type_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增维修类别成功",function () {
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
        table.reload('repairType', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });


    table.render({
        elem: '#repairType',
        url:repair_type_url.type_list,
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
                    field: 'repairTypeNo',
                    title: '维修类别编号',
                    minWidth:170

                }, {
                field: 'repairTypeName',
                title: '维修类别名称',
                minWidth:150

            }, {
                field: 'remark',
                title: '备注',
                minWidth:150

            }, {
                field: 'createTime',
                title: '创建时间',
                minWidth:170

            }, {
                field: 'updateTime',
                title: '更新时间',
                minWidth:170

            }, {
                fixed: 'right',
                title: "操作",
                width: 200,
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
