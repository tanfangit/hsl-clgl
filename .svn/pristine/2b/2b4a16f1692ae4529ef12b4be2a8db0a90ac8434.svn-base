/**
 * 救援单列表
 * Created by zhangqiao on 2018/4/9.
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

        $("#rolesID").html("");//清空下拉选
        var	title;//弹出层主题
        if(type==0){

            console.log(data);
            layer.open({
                type: 2,
                shade: 0.8,
                title: '', //不显示标题
                area: ["80%", "90%"],
                end: function () {//重新加载
                    window.parent.location.reload();
                },
                content: window.baseUrl+'/modules/rescue/rescueDetail.html?rescueId='+data.rescueId,
                success: function(layero, index){

                }
            });

            //查看详情 确定事件
            form.on('submit(InfoSure)', function(data){
                window.parent.location.reload();
                parent.layer.close();
            });

        }

    }


    $.ajax({//发送请求加载救援类型
        type:'POST',
        dataType:'json',
        url:sys_dict_url.dict_select+"rescue_type",
        success: function(data) {
            if(data.code==0){
                $.each(data.dictValueList,function(key,values){
                    $("#rescueType").append('<option value="'+values.value  +'">'+ values.name + '</option>');
                });
                form.render();

            }

        }
    });

    $.ajax({//发送请求加载救援类型
        type:'POST',
        dataType:'json',
        url:sys_dict_url.dict_select+"rescue_status",
        success: function(data) {
            if(data.code==0){
                $.each(data.dictValueList,function(key,values){
                    $("#rescueStatus").append('<option value="'+values.value  +'">'+ values.name + '</option>');
                });
                form.render();

            }

        }
    });


    //点击搜索按钮
    form.on('submit(search)', function(data){
        //console.log(data.elem) //被执行search事件的元素DOM对象，一般为button对象
        // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        table.reload('demo', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });



    table.render({
        elem: '#demo',
        url:rescue_order_url.rescue_list,
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
                    field: 'rescueId',
                    title: '救援单号',
                    minWidth:150

                }, {
                field: 'createTime',
                title: '发起时间',
                minWidth:150

            }, {
                field: 'rescuePerson',
                title: '联系人',
                minWidth:100

            }, {
                field: 'rescuePhone',
                title: '联系电话',
                minWidth:100

            }, {
                field: 'rescueTypeName',
                title: '救援类型',
                minWidth:100

            }, {
                field: 'rescueStatus',
                title: '救援单状态',
                templet: function(d) {
                    if(d.rescueStatus == 1) {
                        return "已提交"
                    } else if(d.rescueStatus == 2){
                        return "已派单"
                    }else if(d.rescueStatus == 3){
                        return "已接单"
                    }else if(d.rescueStatus == 4){
                        return "救援中"
                    }else if(d.rescueStatus == 5){
                        return "已完成"
                    }else if(d.rescueStatus == 6){
                        return "已评价"
                    }else {
                        return "取消订单"
                    }
                }

            }, {
                field: 'isNeedTrailer',
                title: '拖车',
                templet: function(d) {
                    if(d.isNeedTrailer ==1) {
                        return "需要"
                    }else {
                        return "不需要"
                    }
                }

            }, {
                field: 'trailerListStatus',
                title: '拖车状态',
                templet: function(d) {
                    if(d.trailerListStatus ==0) {
                        return "已派车"
                    }else if(d.trailerListStatus ==1){
                        return "完成"
                    }else{
                        return "-"
                    }
                }

            }, {
                field: 'jcLisId',
                title: '接车单号',
                minWidth:100

            }, {
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
