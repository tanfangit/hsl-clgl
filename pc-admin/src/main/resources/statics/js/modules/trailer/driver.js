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
    var companyData;
   table.on('tool(driver)', function(obj) {
       var data = obj.data;
       if (obj.event === 'detail') {//查看
           fn_supplierOperate(0, data);

       } else(obj.event === 'edit')
       {//编辑
           fn_supplierOperate(1, data);
       }

    });

    //点击新增司机
    $("#insertUserButton").click(function(){
        fn_supplierOperate(3)
    });

    function fn_supplierOperate(type,data){
        var	title;//弹出层主题
        if(type==1) {
            console.log(data)
            title = '编辑拖车司机信息';
            var trailerDriverId = data.trailerDriverId;
            $.ajax({ //查询拖车司机信息
                type: "POST",
                url: trailer_driver_url.driver_info+ trailerDriverId,
                contentType: "application/json",
                success: function (r) {
                    if (r.code == 0) {
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
                        var trailerDriverStatus=r.trailerDriver.trailerDriverStatus;
                        //单选框
                        $('input:radio[name=driverStatus]').each(function(index, el) {
                            if(el.value==trailerDriverStatus){
                                el.checked = true;
                            }else if(el.value==trailerDriverStatus){
                                el.checked = true;
                            }
                        })
                        //加载所属公司下来选
                        $.each(companyData.rows,function(key,values){
                            $("#addCompanyNme").append('<option value="'+values.trailerCompanyId +'">'+ values.trailerCompanyName + '</option>');
                        });
                       var trailerCompanyId= r.trailerDriver.trailerCompanyId;
                        $('select[name="addCompanyNme"]').val(trailerCompanyId);
                        $("#confirmBox input[name=driverName]").val(r.trailerDriver.trailerDriverName);
                        $("#confirmBox input[name=driverPhone]").val(r.trailerDriver.trailerDriverMobile);
                        $("#confirmBox input[name=addCompanyNme]").val(r.trailerDriver.trailerCompanyName);
                        $("#confirmBox input[name=remark]").val(r.trailerDriver.trailerDriverRemark);
                        form.render('radio');
                        form.render();
                    } else {
                        layer.msg(r.msg);
                    }

                }
            });

            //点击确定事件
            form.on('submit(sure)', function(data){
                console.log("data==="+data.field);
                var  driverName= data.field.driverName;
                var  driverPhone= data.field.driverPhone;
                var  addCompanyNme= data.field.addCompanyNme;
                var  driverStatus= data.field.driverStatus;
                var  remark= data.field.remark;
                var _jsonFilter={
                    trailerDriverId:trailerDriverId,
                    trailerDriverName:driverName,
                    trailerDriverMobile:driverPhone,
                    trailerCompanyId:addCompanyNme,
                    trailerDriverStatus :driverStatus,
                    trailerDriverRemark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);

                $.ajax({//跟新拖车司机
                    type: "POST",
                    url:trailer_driver_url.driver_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("编辑拖车司机信息成功!",function () {
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

        }else if(type==3){//新增
                title="新增拖车司机";
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
            //清空输入框
            $("#confirmBox input").val("")
            //清空单选框
            $('input:radio[name=driverStatus]').each(function(index, el) {
                    el.checked = false;
            })
            form.render('radio');
            //加载所属公司下来选
            $.each(companyData.rows,function(key,values){
                $("#addCompanyNme").append('<option value="'+values.trailerCompanyId +'">'+ values.trailerCompanyName + '</option>');
            });
            form.render();

            //点击确定事件
            form.on('submit(sure)', function(data){
                console.log("data==="+data.field);
                var  driverName= data.field.driverName;
                var  driverPhone= data.field.driverPhone;
                var  addCompanyNme= data.field.addCompanyNme;
                var  driverStatus= data.field.driverStatus;
                var  remark= data.field.remark;
                var _jsonFilter={
                    trailerDriverName:driverName,
                    trailerDriverMobile:driverPhone,
                    trailerCompanyId:addCompanyNme,
                    trailerDriverStatus :driverStatus,
                    trailerDriverRemark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                console.log(formatedata);

            $.ajax({//新增拖车司机
                    type: "POST",
                    url:trailer_driver_url.driver_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增拖车司机成功",function () {
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
        table.reload('driver', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });


    $.ajax({//发送请求加载所属公司下拉选
        type:'POST',
        dataType:'json',
        url:trailer_company_url.company_all,
        success: function(data) {
            if(data.code==0){
                console.log(data)
                $.each(data.trailerCompanyList,function(key,values){
                    $("#companyName").append('<option value="'+values.trailerCompanyId +'">'+ values.trailerCompanyName + '</option>');
                });
                companyData=data;
                form.render();

            }

        }
    });
    table.render({
        elem: '#driver',
        url:trailer_driver_url.driver_list,
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
                field: 'trailerDriverName',
                title: '司机姓名',
               minWidth:120

            }, {
                field: 'trailerDriverMobile',
                title: '手机号',
                minWidth:120

            }, {
                field: 'createTime',
                title: '创建时间',
                minWidth:120

            }, {
                field: 'trailerDriverStatus',
                title: '工作状态',
                templet: function(d) {
                    if(d.trailerDriverStatus == 1) {
                        return "在职"
                    } else {
                        return "离职"
                    }
                },
                minWidth:50

            }, {
                field: 'trailerCompanyName',
                title: '所属公司',
                minWidth:50

            }
           , {
                fixed: 'right',
                title: "操作",
                width: 100,
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
