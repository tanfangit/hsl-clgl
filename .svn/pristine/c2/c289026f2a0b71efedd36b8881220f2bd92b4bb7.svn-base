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
    var repariPartData;
    table.on('tool(repairItem)', function(obj) {
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

        }


    });

   //点击新增用户
    $("#insertUserButton").click(function(){
        fn_supplierOperate(3)
    });


    function fn_supplierOperate(type,data){
        var	title;//弹出层主题
        if(type==0){
            title='查看维修项目';
            //当前修改的维类项目id
            var repairItemId=data.repairItemId;
            $.ajax({ //查询维修项目信息
                type: "POST",
                url:repair_item_url.item_info+repairItemId,
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
                        console.log(r);
                        //维修类别
                        $("#repairType").append('<option value="'+r.repairItem.repairTypeId  +'">'+ r.repairItem.repairTypeName + '</option>');
                        $('select[name="repairType"]').val(r.repairItem.repairTypeId);
                        //加载维修部件下拉选
                        $("#repairPartAdd").append('<option value="'+r.repairItem.repairItemPosition +'">'+ r.repairItem.repairItemPositionName + '</option>');
                        //默认选中已拥有的维修部件
                        $('select[name="repairPartAdd"]').val(r.repairItem.repairItemPosition);
                        //维修项目
                        $("#confirmBox input[name=repairName]").val(r.repairItem.repairItemName);
                        $("#confirmBox input[name=repariWorkHour]").val(r.repairItem.repairWorkHours);
                        $("#confirmBox input[name=workFee]").val(r.repairItem.workFee);
                        $("#confirmBox input[name=InnerHours]").val(r.repairItem.withinHours);
                        $("#confirmBox input[name=pyCode]").val(r.repairItem.pinyinCode);
                        $("#confirmBox input[name=remark]").val(r.repairItem.remark);
                        $("#confirmBox input[name=repairName]").attr("readonly","readonly");
                        $("#confirmBox input[name=repariWorkHour]").attr("readonly","readonly");
                        $("#confirmBox input[name=repairName]").attr("readonly","readonly");
                        $("#confirmBox input[name=workFee]").attr("readonly","readonly");
                        $("#confirmBox input[name=InnerHours]").attr("readonly","readonly");
                        $("#confirmBox input[name=pyCode]").attr("readonly","readonly");
                        $("#confirmBox input[name=remark]").attr("readonly","readonly");

                        form.render();
                    }else{
                        layer.msg(r.msg);
                    }

                }
            });

            //查看详情 确定事件
            form.on('submit(sure)', function(data){
                window.parent.location.reload();
                parent.layer.close();
            });

        }else if(type==1){
            title='编辑维修项目';
            //当前修改的维类项目id
            var repairItemId=data.repairItemId;
            $.ajax({ //查询维修项目信息
                type: "POST",
                url:repair_item_url.item_info+repairItemId,
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
                        console.log(r);
                        $.ajax({//发送请求加载维修类别
                            type:'POST',
                            dataType:'json',
                            url:repair_type_url.type_all,
                            success: function(data) {
                                if(data.code==0){
                                    //拼接维修类别下拉选
                                    $.each(data.allRepairType,function(key,values){
                                        $("#repairType").append('<option value="'+values.repairTypeId  +'">'+ values.repairTypeName + '</option>');
                                    });
                                    $('select[name="repairType"]').val(r.repairItem.repairTypeId);

                                    form.render();

                                }else{
                                    layer.msg(r.msg);
                                }

                            }

                        });

                        //加载维修部件下拉选
                        $.each(repariPartData.dictValueList,function(key,values){
                            $("#repairPartAdd").append('<option value="'+values.id  +'">'+ values.name + '</option>');
                        });
                        //默认选中已拥有的维修部件
                        $('select[name="repairPartAdd"]').val(r.repairItem.repairItemPosition);
                        //维修项目
                        $("#confirmBox input[name=repairName]").val(r.repairItem.repairItemName);
                        $("#confirmBox input[name=repariWorkHour]").val(r.repairItem.repairWorkHours);
                        $("#confirmBox input[name=workFee]").val(r.repairItem.workFee);
                        $("#confirmBox input[name=InnerHours]").val(r.repairItem.withinHours);
                        $("#confirmBox input[name=pyCode]").val(r.repairItem.pinyinCode);
                        $("#confirmBox input[name=remark]").val(r.repairItem.remark);

                        form.render();
                    }else{
                        layer.msg(r.msg);
                    }

                }
            });

            //修改维修项目-点击确定事件
            form.on('submit(sure)', function(data){
                console.log(data);
                var  repairType= data.field.repairType;
                var  repairPartAdd= data.field.repairPartAdd;
                var  repairItemName= data.field.repairName;
                var  repairWorkHours= data.field.repariWorkHour;
                var  workFee= data.field.workFee;
                var  InnerHours= data.field.InnerHours;
                var  pyCode= data.field.pyCode;
                var  remark= data.field.remark;

                var _jsonFilter={
                    repairItemId:repairItemId,
                    repairTypeId:repairType,
                    repairItemPosition:repairPartAdd,
                    repairItemName:repairItemName,
                    repairWorkHours :repairWorkHours,
                    workFee:workFee,
                    withinHours:InnerHours,
                    pinyinCode:pyCode,
                    remark: remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log("formatedata=="+formatedata);
                //修改维修类别
                $.ajax({
                    type: "POST",
                    url:repair_item_url.item_update,
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


        }else if(type==2){//删除维修项目
            //当前修改的维类项目id
            var repairItemId=data.repairItemId;
            $.ajax({
                type: "POST",
                url:repair_item_url.item_delete+repairItemId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除维修项目成功",function () {
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
            title='新增维修项目';
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


            $.ajax({//发送请求加载维修类别
                type:'POST',
                dataType:'json',
                url:repair_type_url.type_all,
                success: function(data) {
                    if(data.code==0){
                        //拼接维修类别下拉选
                        $.each(data.allRepairType,function(key,values){
                            $("#repairType").append('<option value="'+values.repairTypeId  +'">'+ values.repairTypeName + '</option>');
                        });

                        //加载维修部件下拉选
                        $.each(repariPartData.dictValueList,function(key,values){
                            $("#repairPartAdd").append('<option value="'+values.id  +'">'+ values.name + '</option>');
                        });
                        form.render();

                    }else{
                        layer.msg(r.msg);
                    }

                }
            });

            //清空
            $("#confirmBox input,#confirmBox select").val("")

            //点击确定事件
            form.on('submit(sure)', function(data){
                var  repairType= data.field.repairType;
                var  repairPartAdd= data.field.repairPartAdd;
                var  repairItemName= data.field.repairName;
                var  repairWorkHours= data.field.repariWorkHour;
                var  workFee= data.field.workFee;
                var  InnerHours= data.field.InnerHours;
                var  pyCode= data.field.pyCode;
                var  remark= data.field.remark;

                var _jsonFilter={
                    repairTypeId:repairType,
                    repairItemPosition:repairPartAdd,
                    repairItemName:repairItemName,
                    repairWorkHours :repairWorkHours,
                    workFee:workFee,
                    withinHours:InnerHours,
                    pinyinCode:pyCode,
                    remark: remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);
                //新增维修项目
                $.ajax({
                    type: "POST",
                    url:repair_item_url.item_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增维修项目成功",function () {
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
        table.reload('repairItem', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });



    $.ajax({//发送请求加载维修部件
        type:'POST',
        dataType:'json',
        url:dict_value_url.dict_query+"repair_position",
        success: function(data) {
            if(data.code==0){
                $.each(data.dictValueList,function(key,values){
                    $("#repairPart").append('<option value="'+values.value  +'">'+ values.name + '</option>');
                });
                repariPartData = data;
                form.render();

            }

        }
    });
    table.render({
        elem: '#repairItem',
        url:repair_item_url.item_list,
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
                field: 'repairItemName',
                title: '项目名称',
               minWidth:120

            }, {
                field: 'repairTypeName',
                title: '所属类别名称',
                minWidth:120

            }, {
                field: 'repairItemPositionName',
                title: '维修部位',
                minWidth:120

            }, {
                field: 'repairWorkHours',
                title: '维修工时',
                minWidth:50

            }, {
                field: 'workFee',
                title: '工时费',
                minWidth:50

            }, {
                field: 'withinHours',
                title: '内部工时',
                minWidth: 50
            }
            , {
                field: 'remark',
                title: '备注',
                minWidth:100

            }, {
                fixed: 'right',
                title: "操作",
                width: 190,
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
