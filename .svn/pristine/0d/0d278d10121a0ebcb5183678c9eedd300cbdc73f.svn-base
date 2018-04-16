layui.use(["element", "form", "table", "laydate"], function() {
    element = layui.element,
        table = layui.table,
        form = layui.form,
        laydate = layui.laydate
    laydate.render({
        elem: '#beginTime',
        type: "date"
    });
    laydate.render({
        elem: '#endTime',
        type: "date"
    })

    form.render();
    var carBrandData;
    table.on('tool(trainTable)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            // layer.msg('查看【' + data.brandName + ' 】品牌');
            fn_supplierOperate(0,data);
        } else if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
        }else if(obj.event === 'del'){//删除
            layer.confirm("确定删除车系名称为【"+data.trainName +"】的记录？", {
                btn : [ '确定', '取消' ]//按钮
            }, function(index) {
                layer.close(index);
                //此处请求后台程序，下方是成功后的前台处理……
                fn_supplierOperate(3,data)
                var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
            });

        }

    });
    var $ = layui.$;
    $('#addTrainName').on('click', function(){
        fn_supplierOperate(2)
    });


    function fn_supplierOperate(type,data){

        var	title = "";
        if(type==0){
            title="查看车系";
        }else if(type==1){
            title="编辑车系";
        }else if(type==2){
            title="新增车系";
        }
        if(type!=3){
            layer.open({
                type: 1,
                shade: 0.8,
                title: title, //不显示标题
                area: ["600px", "500px"],
                end: function () {//重新加载
                    window.parent.location.reload();
                },
                content: $('#infoBox')
            });
        }

        if(type==0){
            $("#confirmBox input[name=updateBrandId]").val(data.brandId);
            $("#confirmBox input[name=updateTrainId]").val(data.id);
            $("#confirmBox input[name=updateRemark]").val(data.remark);
            $("#updateCarBrand").append('<option value="'+data.brandId +'">'+ data.brandName + '</option>');
            $('select[name="updateCarBrand"]').val(data.brandId);
            $("#confirmBox input[name=updateTrainNo]").val(data.trainNo);
            $("#confirmBox input[name=updateTrainName]").val(data.trainName);
            $("#confirmBox input[name=updateBrandId]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTrainId]").attr("readonly","readonly");
            $("#confirmBox input[name=updateRemark]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTrainNo]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTrainName]").attr("readonly","readonly");
            form.on('submit(saveTrain)', function(data){
                $("#confirmBox input[name=updateBrandId]").removeAttr("readonly");
                $("#confirmBox input[name=updateTrainId]").removeAttr("readonly");
                $("#confirmBox input[name=updateRemark]").removeAttr("readonly");
                $("#confirmBox input[name=updateTrainNo]").removeAttr("readonly");
                $("#confirmBox input[name=updateTrainName]").removeAttr("readonly");
                window.location.reload();
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });

        }else if(type==1){
            $("#confirmBox input[name=updateBrandId]").val(data.brandId);
            $("#confirmBox input[name=updateTrainId]").val(data.id);
            $("#confirmBox input[name=updateRemark]").val(data.remark);
            $("#confirmBox input[name=updateTrainNo]").val(data.trainNo);
            $("#confirmBox input[name=updateTrainName]").val(data.trainName);
            var brandId = data.brandId;
            // $.ajax({//发送请求加载车辆品牌下拉框
            //     type:'POST',
            //     dataType:'json',
            //     url:car_brand_url.brand_select,
            //     success: function(data) {
            //         if(data.code==0){
                        $.each(carBrandData.brands,function(key,values){
                            $("#updateCarBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
                        });
                        $('select[name="updateCarBrand"]').val(brandId);
                        form.render();

            //         }
            //
            //     }
            // });
            form.on('submit(saveTrain)', function(data){
                var  trainName= data.field.updateTrainName;
                var  trainNo= data.field.updateTrainNo;
                var  remark= data.field.updateRemark;
                var  brandId= data.field.updateCarBrand;
                var  trainId= data.field.updateTrainId;
                if(brandId == null || brandId == ''){
                    layer.alert('警告：所属品牌为空！');
                    return;
                }
                if(trainNo == null || trainNo == ''){
                    layer.alert('警告：车系编号为空！');
                    return;
                }
                if(trainName == null || trainName == ''){
                    layer.alert('警告：车系名称为空！');
                    return;
                }
                var _jsonFilter={
                    trainName:trainName,
                    trainNo:trainNo,
                    brandId: brandId,
                    id: trainId,
                    remark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改品牌
                $.ajax({
                    type: "POST",
                    url:car_train_url.train_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("编辑车系成功",function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });

                        }else{
                            layer.alert(r.msg,function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else if(type==3){
            // title='删除车系';
            var jsonFilter={
                trainId:data.id
            };
            var formatedata =JSON.stringify(jsonFilter);
            $.ajax({ //删除车系
                type: "POST",
                url:car_train_url.train_delete+data.id,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除车系成功",function () {
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

        }else{
            // $.ajax({//发送请求加载车辆品牌下拉框
            //     type:'POST',
            //     dataType:'json',
            //     url:car_brand_url.brand_select,
            //     success: function(data) {
            //         if(data.code==0){
                        $("#updateCarBrand").append('<option value="">' + "请选择" + '</option>');
                        $.each(carBrandData.brands,function(key,values){
                            $("#updateCarBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
                        });
                        form.render();

            //         }
            //
            //     }
            // });
            //点击确定事件
            form.on('submit(saveTrain)', function(data){
                var  trainName= data.field.updateTrainName;
                var  trainNo= data.field.updateTrainNo;
                var  remark= data.field.updateRemark;
                var  brandId= data.field.updateCarBrand;
                if(brandId == null || brandId == ''){
                    layer.alert('警告：所属品牌为空！');
                    return;
                }
                if(trainNo == null || trainNo == ''){
                    layer.alert('警告：车系编号为空！');
                    return;
                }
                if(trainName == null || trainName == ''){
                    layer.alert('警告：车系名称为空！');
                    return;
                }
                var _jsonFilter={
                    trainName:trainName,
                    trainNo:trainNo,
                    brandId: brandId,
                    remark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //新增车系
                $.ajax({
                    type: "POST",
                    url:car_train_url.train_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增车系成功",function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });
                        }else{
                            layer.alert(r.msg,function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }
        form.render();

    }

    $.ajax({//发送请求加载车辆品牌下拉框
        type:'POST',
        dataType:'json',
        url:car_brand_url.brand_select,
        success: function(data) {
            if(data.code==0){
                $.each(data.brands,function(key,values){
                    $("#carBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
                });
                carBrandData = data;
                form.render();

            }

        }
    });
    table.render({
        elem: '#trainTable',
        url:car_train_url.train_list,
        height: 'full-200',
        response: {
            statusName:'code',//数据状态的字段名称，默认：code
            statusCode: 0,//成功的状态码，默认：0
            msgName:'msg', //状态信息的字段名称，默认：msg
            countName:'total', //数据总数的字段名称，默认：count
            dataName:'rows' //数据列表的字段名称，默认：data
        },
        cols: [
            [ //标题栏
                // {checkbox: true, LAY_CHECKED: true}, //默认全选
                {
                    field: 'trainNo',
                    title: '车系编号',
                    minWidth:150

                }, {
                field: 'brandName',
                title: '所属品牌',
                minWidth:150

            },{
                field: 'trainName',
                title: '车系名称',
                minWidth:150

            },{
                field: 'remark',
                title: '备注',
                minWidth:150

            },  {
                fixed: 'right',
                title: "操作",
                width: 250,
                align: 'center',
                toolbar: '#barDemo'
            }
            ]
        ],
        skin: 'row',
        id: 'testReload',
        even: true,
        page: true,
        limits: [10 ,20, 40,80]
    });
    var $ = layui.$, active = {
        reload: function(){
            var carBrand = $('#carBrand');
            var trainName = $('#trainName');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        carBrand: carBrand.val(),
                        trainName: trainName.val()
                    }
                }
            });
        }
    };

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

})
