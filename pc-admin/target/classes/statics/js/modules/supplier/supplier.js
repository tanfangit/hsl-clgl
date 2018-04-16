
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
        elem: '#endTime',
        type: "date"
    })

    form.render();

    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            fn_supplierOperate(3,data)
            //layer.msg('ID：' + data.id + ' 的查看操作');
        } else if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data)//传值为1时是编辑操作，需要传送行数据用来更新表单
        }

    });




    // document.getElementsByClassName("addSupplier")[0].addEventListener("click",function(){
    //     fn_supplierOperate(2)
    // })


    function fn_supplierOperate(type,data){

        var	title=type==1?"编辑":((type==2)?"新增":"查看");
        layer.open({
            type: 1,
            shade: 0.8,
            title: title, //不显示标题
            area: ["800px", "580px"],
            content: $('#infoBox')
        });
        if(type==1){//编辑
            $("#confirmBox input").attr("readOnly",false); //不可编辑，可以传值
            $("#cooperationStatus").attr("disabled",false);
            $("#supplierUsername").attr("readOnly",true); //不可编辑，可以传值
            $("#confirmBox input[name=supplierUsername]").val(data.supplierUsername);
            $("#confirmBox input[name=supplierName]").val(data.supplierName);
            $("#confirmBox select[name=cooperationStatus]").val(data.cooperationStatus);
            $("#confirmBox input[name=address]").val(data.address);
            $("#confirmBox input[name=headName]").val(data.headName);
            $("#confirmBox input[name=headPhone]").val(data.headPhone);
            $("#confirmBox input[name=companyPhone]").val(data.companyPhone);
            $("#confirmBox input[name=notes]").val(data.notes);
            $("#confirmBox input[name=supplierId]").val(data.supplierId);

            //修改供应商
            form.on('submit(saveSupplier)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  supplierUsername = $("#confirmBox input[name=supplierUsername]").val();
                var  supplierName = $("#confirmBox input[name=supplierName]").val();
                var cooperationStatus = $("#confirmBox select[name=cooperationStatus]").val();
                var  address = $("#confirmBox input[name=address]").val();
                var  headName = $("#confirmBox input[name=headName]").val();
                var  headPhone = $("#confirmBox input[name=headPhone]").val();
                var  companyPhone = $("#confirmBox input[name=companyPhone]").val();
                var  notes = $("#confirmBox input[name=notes]").val();
                var  supplierId = $("#confirmBox input[name=supplierId]").val();
                var _jsonFilter={
                    supplierUsername:supplierUsername,
                    supplierName: supplierName,
                    cooperationStatus:cooperationStatus,
                    address:address,
                    headName:headName,
                    headPhone:headPhone,
                    companyPhone:companyPhone,
                    notes:notes,
                    supplierId:supplierId,
                    supplierIdList:[supplierId]
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: supplier_edit_url.supplier_edit,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(result){
                        if(result.code == 0){//提交成功
                            layer.alert("修改成功",function () {
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
                form.render();
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });


        }else if(type==2){
            $("#confirmBox input,#confirmBox select").val("");
            $("#confirmBox input").attr("readOnly",false);
            $("#confirmBox select").attr("disabled",false);

            //新增供应商
            form.on('submit(saveSupplier)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  supplierId = $("#confirmBox input[name=supplierId]").val();
                var  supplierUsername = $("#confirmBox input[name=supplierUsername]").val();
                var  supplierName = $("#confirmBox input[name=supplierName]").val();
                var cooperationStatus = $("#confirmBox select[name=cooperationStatus]").val();
                var  address = $("#confirmBox input[name=address]").val();
                var  headName = $("#confirmBox input[name=headName]").val();
                var  headPhone = $("#confirmBox input[name=headPhone]").val();
                var  companyPhone = $("#confirmBox input[name=companyPhone]").val();
                var  notes = $("#confirmBox input[name=notes]").val();
               // var  supplierId = $("#temp").val();
                var _jsonFilter={
                    supplierId:supplierId,
                    supplierUsername:supplierUsername,
                    supplierName: supplierName,
                    cooperationStatus:cooperationStatus,
                    address:address,
                    headName:headName,
                    headPhone:headPhone,
                    companyPhone:companyPhone,
                    notes:notes,
                    supplierIdList:[supplierId]
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: supplier_add_url.supplier_add,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(result){
                        if(result.code == 0){//提交成功
                            layer.alert("新增成功",function () {
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
                form.render();
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else{//查看
            $("#confirmBox input").attr("readOnly",true); //不可编辑，可以传值
            $("#cooperationStatus").attr("disabled",true); //不可编辑，可以传值
            $("#confirmBox input[name=supplierUsername]").val(data.supplierUsername);
            $("#confirmBox input[name=supplierName]").val(data.supplierName);
            $("#confirmBox select[name=cooperationStatus]").val(data.cooperationStatus);
            $("#confirmBox input[name=address]").val(data.address);
            $("#confirmBox input[name=headName]").val(data.headName);
            $("#confirmBox input[name=headPhone]").val(data.headPhone);
            $("#confirmBox input[name=companyPhone]").val(data.companyPhone);
            $("#confirmBox input[name=notes]").val(data.notes);
            $("#confirmBox input[name=supplierId]").val(data.supplierId);

            form.on('submit(saveSupplier)', function(data){window.location.reload();});

        }
        form.render();

    }

    table.render({
        elem: '#demo',
        url: supplier_view_url.supplier_list,
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
                    field: 'supplierUsername',
                    title: '供应商用户名',

                }, {
                field: 'supplierName',
                title: '供应商公司名称',

            }, {
                field: 'createTime',
                title: '创建时间',

            },{
                field: 'cooperationStatus',
                title: '合作状态',
                templet: function(d) {
                    if(d.cooperationStatus == 1) {
                        return "合作中"
                    } else {
                        return "终止合作"
                    }
                }
            }, {
                field: 'address',
                title: '地址'

            }, {
                field: 'experience',
                title: '零配件维护'
            }, {
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
            var supplierName = $('#supplierName');
            var beginTime = $('#beginTime');
            var endTime = $('#endTime');
            var status = $('#status');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        supplierName: supplierName.val(),
                        beginTime: beginTime.val(),
                        endTime: endTime.val(),
                        status: status.val()
                    }
                }
            });
        }
    };

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $("#addSupplier").click(function(){
        fn_supplierOperate(2)
    });
})