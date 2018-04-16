
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

    table.render({
        elem: '#demo',
        url: trailerList_url.trailerList_view,
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
                    field: 'trailerListId',
                    title: '拖车单号',

                },{
                field: 'companyName',
                title: '拖车公司',

            },{
                field: 'trailerCarNo',
                title: '拖车车牌号',

            },{
                field: 'driverName',
                title: '司机姓名',

            },{
                field: 'driverMobile',
                title: '手机号',

            },{
                field: 'createTime',
                title: '创建时间',

            },{
                field: 'trailerListType',
                title: '类型',
                templet: function(d) {
                    if (d.trailerListType == "JY") {
                        return '<span>' + "救援" + '</span>'
                    }
                    else {
                        return '<span>' + "事故" + '</span>'
                    }
                }
            },{
                field: 'trailerListStatus',
                title: '状态',
                templet: function(d){
                    if(d.trailerListStatus==0) {
                        return '<span>'+ "已派车" +'</span>'
                    }
                    else {
                        return '<span>'+ "完成" +'</span>'
                    }
                }

            },{
                field: 'rescueOrCaseId',
                title: '对应救援单or事故单号',

            },{
                fixed: 'right',
                title: "操作",
                width: 150,
                align: 'center',
                //toolbar: '#barDemo',
                templet: function(d){
                    if(d.trailerListStatus==0) {
                        return '<button class="edit layui-btn  layui-btn-xs" data-type="edit" lay-event="edit">'+ "完成" +'</button>'
                    }
                    else {
                        return '<button class="edit" disabled="disabled" >'+ "完成" +'</button>'
                    }
                }
            }
            ]
        ],
        skin: 'row',
        id: 'testReload',
        even: true,
        page: true,
        limits: [10, 20, 40, 80],
        done: function (res) {
           // console.log(res);
        }
    });

    function fn_supplierOperate(type,data){
        var _jsonFilter={
            //key值对应mapper里面该字段对应的property
            trailerCompanyId:data.trailerCompanyId,
            createTime: data.createTime,
            createUser:data.createUser,
            rescueOrCaseId:data.rescueOrCaseId,
            trailerCarNo:data.trailerCarNo,
            trailerDriverId:data.trailerDriverId,
            trailerListId:data.trailerListId,
            trailerListStatus:data.trailerListStatus
        };
        var formatedata =JSON.stringify(_jsonFilter);
        $.ajax({//ajax请求提交表单
            type: "POST",
            url: trailerList_url.trailerList_edit,
            contentType: "application/json",
            data: formatedata,
            success: function(result){
                if(result.code == 0){//提交成功
                    layer.alert("编辑成功",function () {
                        location.reload();
                    });
                }else{//提交失败
                    layer.msg(result.msg)
                }
            },
            error:function(e){
                console.log(e);
            }
        });
        $(this).attr("disabled","disabled");
    }

    var $ = layui.$, active = {
        reload: function(){
            var trailerNum = $('#trailerListNum');
            var beginTime = $('#beginTime');
            var endTime = $('#endTime');
            var company = $('#company');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        trailerListNo: trailerNum.val(),
                        beginTime: beginTime.val(),
                        endTime: endTime.val(),
                        trailerCompanyId: company.val()
                    }
                }
            });
        }
    };

    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))*/
           fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
        }
    });

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //发送请求加载拖车公司下拉选
    $.ajax({
        type:'GET',
        dataType:'json',
        url:trailer_company_url.company_view,
        success: function(data) {
            var str='<option value="">' + "请选择" + '</option>';
            for(var i=0;i<data.rows.length;i++){
                str+='<option value="'+ data.rows[i].trailerCompanyId+'">' + data.rows[i].trailerCompanyName+ '</option>'
            }
            //显示后台存在的拖车公司
            $('select[name="company"]').html(str);
            form.render();
        }
    });

})