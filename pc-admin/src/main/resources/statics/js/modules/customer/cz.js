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
    table.on('tool(cz)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {//查看
            fn_supplierOperate(0,data)

        }
    });

    function fn_supplierOperate(type,data){
        var	title;//弹出层主题
        if(type==0) {
            console.log(data);
            title = '查看车主信息';
           // var czId = data.czId;
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
            $("#confirmBox input[name=cZName]").val(data.czName);
            $("#confirmBox input[name=cZphone]").val(data.czPhone);
            $("#confirmBox input[name=carNo]").val(data.carNumber);
            $("#confirmBox input[name=carBrand]").val(data.carBrandName);
            $("#confirmBox input[name=carType]").val(data.carTypeName);
            $("#confirmBox input[name=repairNum]").val(data.repairNumber);
            $("#confirmBox input[name=repairMoney]").val(data.repairAmount);
            form.render();
            //查看详情 确定事件
            form.on('submit(sure)', function (data) {
                window.parent.location.reload();
                parent.layer.close();
            });
              }

        }


    //点击搜索按钮
    form.on('submit(search)', function(data){
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        table.reload('cz', {
            where: data.field
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });


    $.ajax({//发送请求加载车型下拉框
        type:'POST',
        dataType:'json',
        url:car_type_url.type_allType,
        success: function(data) {
            console.log(data.carTypes);
            if(data.code==0){
                $.each(data.carTypes,function(key,values){
                    $("#carType").append('<option value="'+values.id +'">'+ values.typeName + '</option>');
                });
                form.render();

            }

        }
    });
    table.render({
        elem: '#cz',
        url:cz_manager_url.cz_list,
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
                field: 'czName',
                title: '车主姓名',
               minWidth:120

            }, {
                field: 'czPhone',
                title: '联系电话',
                minWidth:120

            }, {
                field: 'carNumber',
                title: '车牌号',
                minWidth:120

            }, {
             field: 'carBrandName',
             title: '品牌',
             minWidth:50

          }, {
                field: 'carTypeName',
                title: '车型',
                minWidth:50

            }, {
                field: 'czAddress',
                title: '地址',
                minWidth: 100
            }
            , {
                field: 'createTime',
                title: '创建时间',
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
