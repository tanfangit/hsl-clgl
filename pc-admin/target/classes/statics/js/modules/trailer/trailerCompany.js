
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

    function fn_supplierOperate(type,data){

        var	title=type==1?"编辑":((type==2)?"新增":"查看");
        layer.open({
            type: 1,
            shade: 0.8,
            title: title, //不显示标题
            area: ["800px", "600px"],
            end: function () {//重新加载
                window.parent.location.reload();
            },
            content: $('#infoBox')
        });
        if(type==1){//编辑
            //先加载当前区，再根据市名请求该市下所有区
            var str2='<option value="'+data.trailerCompanyXjdm+'">' + data.area + '</option>';
            var areaId = data.trailerCompanyXjdm;
            $.ajax({
                type:'GET',
                dataType:'json',
                url:contextPath+'/area/xj/parentId/'+data.trailerCompanyDjdm,
                success: function(data) {
                    for(var i=0;i<data.area.length;i++){
                        if(areaId == data.area[i].id ) {
                            continue;
                        }
                        str2+='<option value="'+ data.area[i].id+'">' + data.area[i].name+ '</option>'
                    }
                    //显示后台存在的市
                    $('select[name="area"]').html(str2);

                },complete:function () {
                    form.render();
                }
            });
            //先加载当前市，再根据省名请求该省下所有市
            var str='<option value="'+data.trailerCompanyDjdm+'">' + data.city + '</option>';
            var cityId = data.trailerCompanyDjdm;
            $.ajax({
                type:'GET',
                dataType:'json',
                url:contextPath+'/area/dj/parentId/'+data.trailerCompanySjdm,
                success: function(data) {
                    for(var i=0;i<data.area.length;i++){
                        if(cityId == data.area[i].id ) {
                            continue;
                        }
                        str+='<option value="'+ data.area[i].id+'">' + data.area[i].name+ '</option>'
                    }
                    //显示后台存在的市
                    $('select[name="city"]').html(str);
                },complete:function () {
                    form.render();
                }
            });

            $("#confirmBox input").attr("readOnly",false);
            $("#confirmBox select").attr("disabled",false);
            $("#confirmBox input[name=companyId]").val(data.trailerCompanyId);
            $("#confirmBox input[name=companyName]").val(data.trailerCompanyName);
            $("#confirmBox input[name=companyPerson]").val(data.trailerCompanyPerson);
            $("#confirmBox input[name=companyMobile]").val(data.trailerCompanyMobile);
            $("#confirmBox select[name=province]").val(data.trailerCompanySjdm);
            $("#confirmBox select[name=city]").val(data.city);
            $("#confirmBox select[name=area]").val(data.area);
            $("#confirmBox input[name=companyPhone]").val(data.trailerCompanyPhone);
            $("#confirmBox input[name=address]").val(data.trailerCompanyAddress);
            $("#confirmBox input[name=remark]").val(data.trailerCompanyRemark);

            //修改拖车公司
            form.on('submit(saveCompany)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  companyId = $("#confirmBox input[name=companyId]").val();
                var  companyName = $("#confirmBox input[name=companyName]").val();
                var  companyPerson = $("#confirmBox input[name=companyPerson]").val();
                var  companyMobile = $("#confirmBox input[name=companyMobile]").val();
                var  province = $("#confirmBox select[name=province]").val();
                var  city = $("#confirmBox select[name=city]").val();
                var  area = $("#confirmBox select[name=area]").val();
                var  companyPhone = $("#confirmBox input[name=companyPhone]").val();
                var  address = $("#confirmBox input[name=address]").val();
                var  remark = $("#confirmBox input[name=remark]").val();
                var _jsonFilter={
                    //key值对应mapper里面该字段对应的property
                    trailerCompanyId:companyId,
                    trailerCompanyName:companyName,
                    trailerCompanyPerson: companyPerson,
                    trailerCompanyMobile:companyMobile,
                    trailerCompanySjdm:province,
                    trailerCompanyDjdm:city,
                    trailerCompanyXjdm:area,
                    trailerCompanyPhone:companyPhone,
                    trailerCompanyAddress:address,
                    trailerCompanyRemark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: trailer_company_url.company_edit,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(result){
                        if(result.code == 0){//提交成功
                            layer.alert("编辑成功",function () {
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


        }else if(type==2){
            $("#confirmBox input,#confirmBox select").val("");
            $("#confirmBox input").attr("readOnly",false);
            $("#confirmBox select").attr("disabled",false);

            //新增拖车公司
            form.on('submit(saveCompany)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  companyId = $("#confirmBox input[name=companyId]").val();
                var  companyName = $("#confirmBox input[name=companyName]").val();
                var  companyPerson = $("#confirmBox input[name=companyPerson]").val();
                var  province = $("#confirmBox select[name=province]").val();
                var  city = $("#confirmBox select[name=city]").val();
                var  area = $("#confirmBox select[name=area]").val();
                var  companyMobile = $("#confirmBox input[name=companyMobile]").val();
                var  companyPhone = $("#confirmBox input[name=companyPhone]").val();
                var  address = $("#confirmBox input[name=address]").val();
                var  remark = $("#confirmBox input[name=remark]").val();
               // var  supplierId = $("#temp").val();
                var _jsonFilter={
                    //key值对应mapper里面该字段对应的property
                    trailerCompanyId:companyId,
                    trailerCompanyName:companyName,
                    trailerCompanyPerson: companyPerson,
                    trailerCompanyMobile:companyMobile,
                    trailerCompanySjdm:province,
                    trailerCompanyDjdm:city,
                    trailerCompanyXjdm:area,
                    trailerCompanyPhone:companyPhone,
                    trailerCompanyAddress:address,
                    trailerCompanyRemark:remark
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: trailer_company_url.company_add,
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
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else{//查看
            $.ajax({
                type:'GET',
                dataType:'json',
                url:contextPath+'/area/xj/'+data.trailerCompanyXjdm,
                success: function(data) {
                    var str='<option value="'+ data.area.id+'">' + data.area.name+ '</option>'
                    //显示后台存在的市
                    $('select[name="area"]').html(str);
                    form.render();
                }
            });
            //根据县区代码通过ajax请求获取县区名称
            $.ajax({
                type:'GET',
                dataType:'json',
                url:contextPath+'/area/dj/'+data.trailerCompanyDjdm,
                success: function(data) {
                    var str='<option value="'+ data.area.id+'">' + data.area.name+ '</option>'
                    //显示后台存在的市
                    $('select[name="city"]').html(str);
                    form.render();
                }
            });

            $("#confirmBox input").attr("readOnly",true); //不可编辑，可以传值
            $("#confirmBox select").attr("disabled",true); //不可编辑
            $("#confirmBox input[name=companyId]").val(data.trailerCompanyId);
            $("#confirmBox input[name=companyName]").val(data.trailerCompanyName);
            $("#confirmBox input[name=companyPerson]").val(data.trailerCompanyPerson);
            $("#confirmBox input[name=companyMobile]").val(data.trailerCompanyMobile);
            $("#confirmBox select[name=province]").val(data.trailerCompanySjdm);
            //$("#confirmBox select[name=city]").val(data.trailerCompanyDjdm);
            //$("#confirmBox select[name=area]").val(data.trailerCompanyXjdm);
            $("#confirmBox input[name=companyPhone]").val(data.trailerCompanyPhone);
            $("#confirmBox input[name=address]").val(data.trailerCompanyAddress);
            $("#confirmBox input[name=remark]").val(data.trailerCompanyRemark);

            form.on('submit(saveCompany)', function(data){window.location.reload();});

        }
        form.render();

    }

    table.render({
        elem: '#demo',
        url: trailer_company_url.company_view,
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
                    field: 'trailerCompanyName',
                    title: '名称',

                },{
                field: 'createTime',
                title: '创建时间',

            },{
                field: 'trailerCompanyPerson',
                title: '负责人'

            }, {
                field: 'trailerCompanyMobile',
                title: '手机号'
            },{
                field: 'province',
                title: '省'
            },{
                field: 'city',
                title: '市'
            },{
                field: 'area',
                title: '区'
            },{
                field: 'trailerCompanyAddress',
                title: '详细地址'
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
            var trailerCompanyName = $('#companyName');
            var beginTime = $('#beginTime');
            var endTime = $('#endTime');
            var type = $('#type');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        trailerCompanyName: trailerCompanyName.val(),
                        beginTime: beginTime.val(),
                        endTime: endTime.val()
                    }
                }
            });
        }
    };

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $("#addCompany").click(function(){
        fn_supplierOperate(2)
    });
    //发送请求加载省下拉选
    $.ajax({
        type:'GET',
        dataType:'json',
        url:contextPath+'/area/sj/list',
        success: function(data) {
            var str='<option value="">' + "请选择所属省" + '</option>';
            for(var i=0;i<data.area.length;i++){
                str+='<option value="'+ data.area[i].id+'">' + data.area[i].name+ '</option>'
            }
            //显示后台存在的省份
            $('select[name="province"]').html(str);
            form.render();
        }
    });

    //点击选择省，发送请求获取该省下的市
    form.on("select(provinceFilter)", function(data){
        $('select[name="city"]').html('');
        $('select[name="area"]').html('');
        //发送请求加载市下拉选
        //取父级代号
        var pcode = data.value;

        $.ajax({
            type:'GET',
            async:false,
            dataType:'json',
            url:contextPath+'/area/dj/parentId/'+pcode,
            success: function(data) {
                var str='<option value="">' + "请选择" + '</option>';
                for(var i=0;i<data.area.length;i++){
                    str+='<option value="'+ data.area[i].id+'">' + data.area[i].name+ '</option>'
                }
                //显示后台存在的市
                $('select[name="city"]').html(str);
                // form.render();
            }
        });
        form.render();
    });

    //点击选择市，发送请求获取该市下的县区
    form.on("select(cityFilter)", function(data){
        //发送请求加载县区下拉选
        //取父级代号
        var pcode = data.value;
        $.ajax({
            type:'GET',
            dataType:'json',
            url:contextPath+'/area/xj/parentId/'+pcode,
            success: function(data) {
                var str='<option value="">' + "请选择" + '</option>';
                for(var i=0;i<data.area.length;i++){
                    str+='<option value="'+ data.area[i].id+'">' + data.area[i].name+ '</option>'
                }
                //显示后台存在的县区
                $('select[name="area"]').html(str);
                form.render();
            }
        })
    });

})