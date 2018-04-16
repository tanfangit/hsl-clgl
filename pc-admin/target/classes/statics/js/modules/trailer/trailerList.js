
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
         if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data)//传值为1时是编辑操作，需要传送行数据用来更新表单
        }
    });


    function fn_supplierOperate(type,data){
        var	title=type==1?"编辑":"新增";
        layer.open({
            type: 1,
            shade: 0.8,
            title: title, //不显示标题
            area: ["500px", "500px"],
            content: $('#infoBox')
        });
        if(type==1){//编辑
            $("#confirmBox input[name=trailerNum]").val(data.trailerCarNo);
            $("#confirmBox select[name=trailerCompany]").val(data.trailerCompanyId);
            $("#confirmBox input[name=trailerId]").val(data.trailerId);

            //修改拖车
            form.on('submit(saveTrailerList)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  trailerNum = $("#confirmBox input[name=trailerNum]").val();
                var  trailerCompany = $("#confirmBox select[name=trailerCompany]").val();
                var  trailerId = $("#confirmBox input[name=trailerId]").val();
                var _jsonFilter={
                    trailerCarNo:trailerNum,
                    trailerCompanyId: trailerCompany,
                    trailerId:trailerId
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: trailer_url.trailer_edit,
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
            //新增拖车
            $("#confirmBox input,#confirmBox select").val("");
            form.on('submit(saveTrailerList)', function(data){
                //console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                var  trailerId = $("#confirmBox input[name=trailerId]").val();
                var  trailerNum = $("#confirmBox input[name=trailerNum]").val();
                var  trailerCompany = $("#confirmBox select[name=trailerCompany]").val();
               // var  supplierId = $("#temp").val();
                var _jsonFilter={
                    trailerCarNo:trailerNum,
                    trailerCompanyId: trailerCompany,
                    trailerId:trailerId
                };
                var formatedata =JSON.stringify(_jsonFilter);
                $.ajax({//ajax请求提交表单
                    type: "POST",
                    url: trailer_url.trailer_add,
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
        }
        form.render();

    }

    table.render({
        elem: '#demo',
        url: trailer_url.trailer_view,
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
                    field: 'trailerCarNo',
                    title: '车牌号',

                },{
                field: 'createTime',
                title: '创建时间',

            }, {
                field: 'companyName',
                title: '所属公司'

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
            var trailerNum = $('#trailerNum');
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
                        trailerNum: trailerNum.val(),
                        beginTime: beginTime.val(),
                        endTime: endTime.val(),
                        company: company.val()
                    }
                }
            });
        }
    };

    $('#reloadTable').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $("#addTrailer").click(function(){
        fn_supplierOperate(2)
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
            $('select[name="trailerCompany"]').html(str);
            form.render();
        }
    });
})