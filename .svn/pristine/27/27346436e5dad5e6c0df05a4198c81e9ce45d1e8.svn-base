
layui.use(["layer","form","table", "laydate"],function(){
    element = layui.element,
        table = layui.table,
        form = layui.form,
        laydate = layui.laydate;
    laydate.render({
        elem: '#beginTime',
        type: "date"
    });
    laydate.render({
        elem: '#year',
        type: "year"
    });
    laydate.render({
        elem: '#endTime',
        type: "date"
    });
    form.render();

    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            fn_supplierOperate(3,data)
            //layer.msg('ID：' + data.id + ' 的查看操作');
        } else if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data)//传值为1时是编辑操作，需要传送行数据用来更新表单
        } else if(obj.event === 'del') {//删除
            layer.confirm("确定删除配件名称为【"+data.partsName +"】的记录？", {
                btn : [ '确定', '取消' ]//按钮
            }, function(index) {
                layer.close(index);
                //此处请求后台程序，下方是成功后的前台处理……
                fn_supplierOperate(4,data)
                var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
            });
        }

    });


    function fn_supplierOperate(type,data){

        var	title=type==1?"编辑":((type==2)?"新增":((type==3)?"查看":"删除"));
        //删除时不打开弹窗
        if(type!=4){
            layer.open({
                type: 1,
                shade: 0.8,
                title: title, //不显示标题
                area: ["90%", "90%"],
                end: function () {//重新加载
                    window.parent.location.reload();
                },
                content: $('#infoBox')
            });
        }

        if(type==1){//编辑信息填充
            //先加载车系，在根据根据品牌加载所有该品牌的车系
            var str;
            $.ajax({
                type:'GET',
                async:false,
                dataType:'json',
                url:car_train_url.train_select+data.brand,
                success: function(data) {
                    for(var i=0;i<data.trains.length;i++){
                        str+='<option value="'+ data.trains[i].id+'">' + data.trains[i].trainName+ '</option>'
                    }
                    //显示后台存在的市
                    $('select[name="carLine"]').html(str);
                    // form.render();
                },error:function(){
                    layer.msg("请选择车系");
                },complete:function () {
                    form.render();
                }
            });
            $("#confirmBox input").attr("readOnly",false);
            $("#confirmBox select").attr("disabled",false);
            $("#confirmBox input[name=partsId]").val(data.partsId);
            $("#confirmBox input[name=partsNum]").val(data.partsNum);
            $("#confirmBox input[name=partsName]").val(data.partsName);
            $("#confirmBox input[name=partsSimpleCode]").val(data.partsSimpleCode);
            $("#confirmBox select[name=brand]").val(data.brand);
            $("#confirmBox select[name=carLine]").val(data.carLine);
            $("#confirmBox input[type=checkbox]").val(data.checkbox);
            $("#confirmBox select[name=part]").val(data.part);
            $("#confirmBox input[name=year]").val(data.year);
            $("#confirmBox input[name=properties]").val(data.properties);
            $("#confirmBox select[name=unit]").val(data.unit);
            $("#confirmBox input[name=cost]").val(data.cost);
            $("#confirmBox input[name=exportPrice]").val(data.exportPrice);
            $("#confirmBox input[name=repairPrice]").val(data.repairPrice);
            $("#confirmBox input[name=claimPrice1]").val(data.claimPrice1);
            $("#confirmBox input[name=claimPrice2]").val(data.claimPrice2);
            $("#confirmBox input[name=torage]").val(data.torage);
            $("#confirmBox input[name=lowerLimit]").val(data.lowerLimit);
            $("#confirmBox input[name=upperLimit]").val(data.upperLimit);
            $("#confirmBox input[name=latestPrice]").val(data.latestPrice);
            $("#confirmBox input[name=branchPrice]").val(data.branchPrice);

            //修改配件
            form.on('submit(saveParts)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  partsId = $("#confirmBox input[name=partsId]").val();
                var  partsNum = $("#confirmBox input[name=partsNum]").val();
                var  partsName = $("#confirmBox input[name=partsName]").val();
                var  partsSimpleCode = $("#confirmBox input[name=partsSimpleCode]").val();
                var  brand = $("#confirmBox select[name=brand]").val();
                var  carLine = $("#confirmBox select[name=carLine]").val();
                var  suitableModel = $("#confirmBox input[type=checkbox]").val();
                var  part = $("#confirmBox select[name=part]").val();
                var  year = $("#confirmBox input[name=year]").val();
                var  properties = $("#confirmBox input[name=properties]").val();
                var  unit = $("#confirmBox select[name=unit]").val();
                var  cost = $("#confirmBox input[name=cost]").val();
                var  exportPrice = $("#confirmBox input[name=exportPrice]").val();
                var  repairPrice = $("#confirmBox input[name=repairPrice]").val();
                var  claimPrice1 = $("#confirmBox input[name=claimPrice1]").val();
                var  claimPrice2 = $("#confirmBox input[name=claimPrice2]").val();
                var  torage = $("#confirmBox input[name=torage]").val();
                var  lowerLimit = $("#confirmBox input[name=lowerLimit]").val();
                var  upperLimit = $("#confirmBox input[name=upperLimit]").val();
                var  latestPrice = $("#confirmBox input[name=latestPrice]").val();
                var  branchPrice = $("#confirmBox input[name=branchPrice]").val();
                var _jsonFilter={
                    partsId:partsId,
                    partsNum:partsNum,
                    partsName: partsName,
                    partsSimpleCode:partsSimpleCode,
                    brand:brand,
                    carLine:carLine,
                    suitableModel:suitableModel,
                    part:part,
                    year:year,
                    properties:properties,
                    unit:unit,
                    cost:cost,
                    exportPrice:exportPrice,
                    repairPrice:repairPrice,
                    claimPrice1:claimPrice1,
                    claimPrice2:claimPrice2,
                    torage:torage,
                    lowerLimit:lowerLimit,
                    upperLimit:upperLimit,
                    latestPrice:latestPrice,
                    branchPrice:branchPrice
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: parts_edit_url.parts_edit,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(result){
                        if(result.code == 0){//提交成功
                            layer.alert("修改配件成功",function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });
                        }else{//提交失败
                            layer.msg(result.msg)
                        }
                    },
                    error:function(e){
                        console.log(e);
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
            form.render();

        }else if(type==2){
            $("#confirmBox input,#confirmBox select").val("");
            $("#confirmBox input").attr("readOnly",false);
            $("#confirmBox select").attr("disabled",false);
            //新增供配件
            form.on('submit(saveParts)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  partsId = $("#confirmBox input[name=partsId]").val();
                var  partsNum = $("#confirmBox input[name=partsNum]").val();
                var  partsName = $("#confirmBox input[name=partsName]").val();
                var  partsSimpleCode = $("#confirmBox input[name=partsSimpleCode]").val();
                var  brand = $("#confirmBox select[name=brand]").val();
               // var brand = $('select[name="brand"]').val();
                var  carLine = $("#confirmBox select[name=carLine]").val();
                var  suitableModel = $("#confirmBox input[type=checkbox]").val();
                var  part = $("#confirmBox select[name=part]").val();
                var  year = $("#confirmBox input[name=year]").val();
                var  properties = $("#confirmBox input[name=properties]").val();
                var  unit = $("#confirmBox select[name=unit]").val();
                var  cost = $("#confirmBox input[name=cost]").val();
                var  exportPrice = $("#confirmBox input[name=exportPrice]").val();
                var  repairPrice = $("#confirmBox input[name=repairPrice]").val();
                var  claimPrice1 = $("#confirmBox input[name=claimPrice1]").val();
                var  claimPrice2 = $("#confirmBox input[name=claimPrice2]").val();
                var  torage = $("#confirmBox input[name=torage]").val();
                var  lowerLimit = $("#confirmBox input[name=lowerLimit]").val();
                var  upperLimit = $("#confirmBox input[name=upperLimit]").val();
                var  latestPrice = $("#confirmBox input[name=latestPrice]").val();
                var  branchPrice = $("#confirmBox input[name=branchPrice]").val();

                // var  supplierId = $("#temp").val();
                var _jsonFilter={
                    partsId:partsId,
                    partsNum:partsNum,
                    partsName: partsName,
                    partsSimpleCode:partsSimpleCode,
                    brand:brand,
                    carLine:carLine,
                    suitableModel:suitableModel,
                    part:part,
                    year:year,
                    properties:properties,
                    unit:unit,
                    cost:cost,
                    exportPrice:exportPrice,
                    repairPrice:repairPrice,
                    claimPrice1:claimPrice1,
                    claimPrice2:claimPrice2,
                    torage:torage,
                    lowerLimit:lowerLimit,
                    upperLimit:upperLimit,
                    latestPrice:latestPrice,
                    branchPrice:branchPrice
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: parts_add_url.parts_add,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(result){
                        if(result.code == 0){//提交成功
                            layer.alert("新增配件成功",function () {
                                window.parent.location.reload();
                                parent.layer.close();
                            });
                        }else{//提交失败
                            layer.msg(result.msg)
                        }
                    },
                    error:function(e){
                        console.log(e);
                    }
                });
                //window.location.reload();
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
            form.render();
        }else if(type==4){
            // title='删除品牌';
            var jsonFilter={
                partsId:data.partsId
            };
            var formatedata =JSON.stringify(jsonFilter);
            $.ajax({ //删除品牌
                type: "POST",
                url:parts_delete_url.parts_delete+data.partsId,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除配件成功",function () {
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
            form.render();
        }else{//查看
            $("#confirmBox input").attr("readOnly",true); //不可编辑，可以传值
            $("#confirmBox select").attr("disabled",true); //不可编辑，可以传值
            $("#confirmBox input[name=partsId]").val(data.partsId);
            $("#confirmBox input[name=partsNum]").val(data.partsNum);
            $("#confirmBox input[name=partsName]").val(data.partsName);
            $("#confirmBox input[name=partsSimpleCode]").val(data.partsSimpleCode);
            $("#confirmBox select[name=brand]").val(data.brand);
            $("#confirmBox select[name=carLine]").val(data.carLine);
            $("#confirmBox input[type=checkbox]").val(data.checkbox);
            $("#confirmBox select[name=part]").val(data.part);
            $("#confirmBox input[name=year]").val(data.year);
            $("#confirmBox input[name=properties]").val(data.properties);
            $("#confirmBox select[name=unit]").val(data.unit);
            $("#confirmBox input[name=cost]").val(data.cost);
            $("#confirmBox input[name=exportPrice]").val(data.exportPrice);
            $("#confirmBox input[name=repairPrice]").val(data.repairPrice);
            $("#confirmBox input[name=claimPrice1]").val(data.claimPrice1);
            $("#confirmBox input[name=claimPrice2]").val(data.claimPrice2);
            $("#confirmBox input[name=torage]").val(data.torage);
            $("#confirmBox input[name=lowerLimit]").val(data.lowerLimit);
            $("#confirmBox input[name=upperLimit]").val(data.upperLimit);
            $("#confirmBox input[name=latestPrice]").val(data.latestPrice);
            $("#confirmBox input[name=branchPrice]").val(data.branchPrice);

            form.on('submit(saveParts)', function(data){window.location.reload();});
        }
        form.render();

    }

    table.render({
        elem: '#demo',
        url: parts_view_url.parts_list,
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
                    field: 'partsNum',
                    title: '配件编号',

                }, {
                field: 'partsName',
                title: '配件名称',

            }, {
                field: 'partName',
                title: '部位',

            },{
                field: 'unitName',
                title: '单位',

            }, {
                field: 'brandName',
                title: '品牌'

            }, {
                field: 'carLineName',
                title: '车系'
            }, {
                field: 'suitableModel',
                title: '合适车型'
            },{
                fixed: 'right',
                title: "操作",
                width: 150,
                align: 'center',
                toolbar: '#barDemo'
            }
            ]
        ],
        skin: 'row',
        id: 'testReload',
        even: true,
        page: true,
        limits: [10, 20, 40, 80]
    });

    var $ = layui.$, active = {
        reload: function(){
            var brandName = $('#brand');
            var partsName = $('#partsName');
            var carLine = $('#carLine')

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        brandName: brandName.val(),
                        partsName: partsName.val(),
                        carLine:carLine.val()
                    }
                }
            });
        }
    };

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

	//新增配件按钮动作
    $("#addParts").click(function(){
        fn_supplierOperate(2)
    });

    //发送请求加载车辆品牌下拉选
    $.ajax({
        type:'POST',
        dataType:'json',
        url:car_brand_url.brand_list,
        success: function(data) {

            var str='<option value="">' + "请选择" + '</option>';
            for(var i=0;i<data.rows.length;i++){
                str+='<option value="'+ data.rows[i].brandId +'">' + data.rows[i].brandName + '</option>'
            }
            //显示后台存在的车辆品牌
            $('select[name="brand"]').html(str);
            //console.log(data);
        },complete:function () {
            form.render();
        }
    });
    //发送请求加载所有车系
    $.ajax({
        type:'GET',
        async:false,
        dataType:'json',
        url:car_train_url.train_list,
        success: function(data) {
            var str='<option value="">' + "请选择" + '</option>';
            for(var i=0;i<data.rows.length;i++){
                str+='<option value="'+ data.rows[i].id+'">' + data.rows[i].trainName+ '</option>'
            }
            //显示后台存在的市
            $('select[name="carLine"]').html(str);
            // form.render();
        },complete:function () {
            form.render();
        }
    });
    form.render();
    // 选择品牌后，加载相应品牌的车系
    form.on("select(brand)", function(data){
        $('select[name="carLine"]').html('');
       // $('select[name="area"]').html('');
        //取父级代号
        var pcode = data.value;

        $.ajax({
            type:'GET',
            async:false,
            dataType:'json',
            url:car_train_url.train_select+pcode,
            success: function(data) {
                var str='<option value="">' + "请选择" + '</option>';
                for(var i=0;i<data.trains.length;i++){
                    str+='<option value="'+ data.trains[i].id+'">' + data.trains[i].trainName+ '</option>'
                }
                //显示后台存在的市
                $('select[name="carLine"]').html(str);
                // form.render();
            },error:function(){
                layer.msg("请选择品牌");
            },complete:function () {
                form.render();
            }
        });
    });

    //发送请求加载所有部位
    $.ajax({
        type:'GET',
        async:false,
        dataType:'json',
        url:dict_value_url.dict_query+"repair_position",
        success: function(data) {
            var str='<option value="">' + "请选择" + '</option>';
            for(var i=0;i<data.dictValueList.length;i++){
                str+='<option value="'+ data.dictValueList[i].id+'">' + data.dictValueList[i].name+ '</option>'
            }
            //显示后台存在的部位
            $('select[name="interest"]').html(str);
            $('select[name="part"]').html(str);
            // form.render();
        },complete:function () {
            form.render();
        }
    });

    //发送请求加载所有单位
    $.ajax({
        type:'GET',
        async:false,
        dataType:'json',
        url:dict_value_url.dict_query+"unit",
        success: function(data) {
            var str='<option value="">' + "请选择" + '</option>';
            for(var i=0;i<data.dictValueList.length;i++){
                str+='<option value="'+ data.dictValueList[i].id+'">' + data.dictValueList[i].name+ '</option>'
            }
            //显示后台存在的单位
            $('select[name="unit"]').html(str);
            // form.render();
        },complete:function () {
            form.render();
        }
    });


})