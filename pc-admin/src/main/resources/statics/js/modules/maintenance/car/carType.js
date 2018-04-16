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
    //存放Brand下拉框所有选项信息
    var carBrandData;
    //引入查看标志，为false则意味着查看状态下无需联动加载车系信息
    var detailFlag = false;
    table.on('tool(typeTable)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            // layer.msg('查看【' + data.brandName + ' 】品牌');
            fn_supplierOperate(0,data);
            detailFlag = true;
        } else if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
        }else if(obj.event === 'del'){//删除
            layer.confirm("确定删除车型名称为【"+data.typeName +"】的记录？", {
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
    $('#addTypeName').on('click', function(){
        fn_supplierOperate(2);
    });
    form.on('select(carBrand)', function(data){
        // console.log(data.elem); //得到select原始DOM对象
        // console.log(data.value); //得到被选中的值
        loadTrain(data.value,"carTrain");
    });
    form.on('select(updateCarBrand)', function(data){
        // console.log(data.elem); //得到select原始DOM对象
        // console.log(data.value); //得到被选中的值
        if(detailFlag == false){
            loadTrain(data.value,"updateCarTrain");
        }
    });


    function fn_supplierOperate(type,data){

        var	title = "";
        if(type==0){
            title="查看车型";
        }else if(type==1){
            title="编辑车型";
        }else if(type==2){
            title="新增车型";
        }
        if(type!=3){
            layer.open({
                type: 1,
                shade: 0.8,
                title: title, //不显示标题
                area: ["600px", "500px"],
                end: function () {//重新加载
                    clearInfoBox();
                    window.parent.location.reload();
                    detailFlag = false;
                    // loadTable(carTypeParam);
                },
                content: $('#infoBox')
            });
        }

        if(type==0){
            $("#confirmBox input[name=updateBrandId]").val(data.brandId);
            $("#confirmBox input[name=updateTrainId]").val(data.trainId);
            $("#confirmBox input[name=updateTypeId]").val(data.id);
            $("#confirmBox input[name=updateRemark]").val(data.remark);
            $("#updateCarBrand").append('<option value="'+data.brandId +'">'+ data.brandName + '</option>');
            $('select[name="updateCarBrand"]').val(data.brandId);
            $("#updateCarTrain").append('<option value="'+data.trainId +'">'+ data.trainName + '</option>');
            $('select[name="updateCarTrain"]').val(data.trainId);
            $("#confirmBox input[name=updateTypeNo]").val(data.typeNo);
            $("#confirmBox input[name=updateTypeName]").val(data.typeName);
            $("#confirmBox input[name=updateBrandId]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTrainId]").attr("readonly","readonly");
            $("#confirmBox input[name=updateRemark]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTypeNo]").attr("readonly","readonly");
            $("#confirmBox input[name=updateTypeName]").attr("readonly","readonly");
            form.on('submit(saveType)', function(data){
                $("#confirmBox input[name=updateBrandId]").removeAttr("readonly");
                $("#confirmBox input[name=updateTrainId]").removeAttr("readonly");
                $("#confirmBox input[name=updateRemark]").removeAttr("readonly");
                $("#confirmBox input[name=updateTypeNo]").removeAttr("readonly");
                $("#confirmBox input[name=updateTypeName]").removeAttr("readonly");
                clearInfoBox();
                window.location.reload();
                detailFlag = false;
                // loadTable(carTypeParam);
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });

        }else if(type==1){
            $("#confirmBox input[name=updateBrandId]").val(data.brandId);
            $("#confirmBox input[name=updateTrainId]").val(data.trainId);
            $("#confirmBox input[name=updateTypeId]").val(data.id);
            $("#confirmBox input[name=updateRemark]").val(data.remark);
            $("#confirmBox input[name=updateTypeNo]").val(data.typeNo);
            $("#confirmBox input[name=updateTypeName]").val(data.typeName);
            var brandId = data.brandId;
            var trainId = data.trainId;
            // $.ajax({//发送请求加载车辆品牌下拉框
            //     type:'POST',
            //     dataType:'json',
            //     url:car_brand_url.brand_select,
            //     success: function(data) {
            //         if(data.code==0){
                        $.each(carBrandData.brands,function(key,values){
                            $("#updateCarBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
                        });

                        //加载车系
                        loadTrain(brandId,"updateCarTrain");
                        $('select[name="updateCarBrand"]').val(brandId);
                        $('select[name="updateCarTrain"]').val(data.trainId);
                        form.render();

            //         }
            //
            //     }
            // });
            form.on('submit(saveType)', function(data){
                var  typeName= data.field.updateTypeName;
                var  typeNo= data.field.updateTypeNo;
                var  remark= data.field.updateRemark;
                var  trainId= data.field.updateCarTrain;
                var  typeId= data.field.updateTypeId;
                if(trainId == null || trainId == ''){
                    layer.alert('警告：所属车系为空！');
                    return;
                }
                if(typeNo == null || typeNo == ''){
                    layer.alert('警告：车型编号为空！');
                    return;
                }
                if(typeName == null || typeName == ''){
                    layer.alert('警告：车型名称为空！');
                    return;
                }
                var _jsonFilter={
                    typeName:typeName,
                    typeNo:typeNo,
                    trainId: trainId,
                    id: typeId,
                    remark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改品牌
                $.ajax({
                    type: "POST",
                    url:car_type_url.type_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("编辑车型成功",function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });

                        }else{
                            layer.alert(r.msg,function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else if(type==3){
            // title='删除车系';
            var jsonFilter={
                typeId:data.id
            };
            var formatedata =JSON.stringify(jsonFilter);
            $.ajax({ //删除车系
                type: "POST",
                url:car_type_url.type_delete+data.id,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除车型成功",function () {
                            window.parent.location.reload();
                            parent.layer.close();
                            // loadTable(carTypeParam);
                        });
                    }else{
                        layer.msg(r.msg,function () {
                            window.parent.location.reload();
                            parent.layer.close();
                            // loadTable(carTypeParam);
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
                        $("#updateCarBrand").append('<option value="">' + "请选择品牌" + '</option>');
                        $.each(carBrandData.brands,function(key,values){
                            $("#updateCarBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
                        });
                        form.render();

            //         }
            //
            //     }
            // });
            //点击确定事件
            form.on('submit(saveType)', function(data){
                var  typeName= data.field.updateTypeName;
                var  typeNo= data.field.updateTypeNo;
                var  remark= data.field.updateRemark;
                var  trainId= data.field.updateCarTrain;
                if(trainId == null || trainId == ''){
                    layer.alert('警告：所属车系为空！');
                    return;
                }
                if(typeNo == null || typeNo == ''){
                    layer.alert('警告：车型编号为空！');
                    return;
                }
                if(typeName == null || typeName == ''){
                    layer.alert('警告：车型名称为空！');
                    return;
                }
                var _jsonFilter={
                    typeName:typeName,
                    typeNo:typeNo,
                    trainId: trainId,
                    remark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //新增车型
                $.ajax({
                    type: "POST",
                    url:car_type_url.type_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增车型成功",function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });
                        }else{
                            layer.alert(r.msg,function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
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
    //加载车系下拉框
    function loadTrain(brandId,selectId){
        var jsonFilter={
            brandId:brandId
        };
        var formatedata =JSON.stringify(jsonFilter);
        $.ajax({//发送请求加载车系下拉框
            type:'POST',
            dataType:'json',
            url:car_train_url.train_select+brandId,
            async: false,
            success: function(data) {
                if(data.code==0){
                    $("#"+selectId).html('<option value="">' + "请选择车系" + '</option>');
                    $.each(data.trains,function(key,values){
                        $("#"+selectId).append('<option value="'+values.id +'">'+ values.trainName + '</option>');
                    });
                    form.render();

                }

            }
        });
    }
    function clearInfoBox(){
        $("#confirmBox input[name=updateBrandId]").val("");
        $("#confirmBox input[name=updateTrainId]").val("");
        $("#confirmBox input[name=updateTypeId]").val("");
        $("#confirmBox input[name=updateRemark]").val("");
        $("#confirmBox input[name=updateTypeNo]").val("");
        $("#confirmBox input[name=updateTypeName]").val("");
        $("#confirmBox input[name=updateBrandId]").removeAttr("readonly");
        $("#confirmBox input[name=updateTrainId]").removeAttr("readonly");
        $("#confirmBox input[name=updateRemark]").removeAttr("readonly");
        $("#confirmBox input[name=updateTypeNo]").removeAttr("readonly");
        $("#confirmBox input[name=updateTypeName]").removeAttr("readonly");
        $("#updateCarBrand").html('<option value="">' + "请选择品牌" + '</option>');
        $("#updateCarTrain").html('<option value="">' + "请选择车系" + '</option>');
    }
    //恢复查询
    // function loadTable(carTypeParam){
    //     if(carTypeParam.flag == true){
    //         $('select[name="carBrand"]').val(carTypeParam.carBrand);
    //         $('select[name="carTrain"]').val(carTypeParam.carTrain);
    //         $('input[name="typeName"]').val(carTypeParam.typeName);
    //         table.reload('testReload', {
    //             page: {
    //                 curr: 1 //重新从第 1 页开始
    //             }
    //             ,where: {
    //                 key: {
    //                     carBrand: carTypeParam.carBrand,
    //                     carTrain: carTypeParam.carTrain,
    //                     typeName: carTypeParam.typeName
    //                 }
    //             }
    //         });
    //     }
    // }
    table.render({
        elem: '#typeTable',
        url:car_type_url.type_list,
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
                    field: 'typeNo',
                    title: '车型编号',
                    minWidth:150

                }, {
                field: 'brandName',
                title: '所属品牌',
                minWidth:150

            },{
                field: 'trainName',
                title: '所属车系',
                minWidth:150

            },{
                field: 'typeName',
                title: '车型名称',
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
            //打开存储开关
            // carTypeParam.flag = true;
            var carBrand = $('#carBrand').val();
            var carTrain = $('#carTrain').val();
            var typeName = $('#typeName').val();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        carBrand: carBrand,
                        carTrain: carTrain,
                        typeName: typeName
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
