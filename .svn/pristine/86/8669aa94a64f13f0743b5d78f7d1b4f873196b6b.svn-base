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

        table.on('tool(DicTable)', function(obj) {
            var data = obj.data;
             if(obj.event === 'edit') {
                //layer.alert('编辑行：<br>' + JSON.stringify(data))
                fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
            }else if(obj.event === 'del'){//删除
                layer.confirm("确定删除类型名称为【"+data.name +"】的记录？", {
                    btn : [ '确定', '取消' ]//按钮
                }, function(index) {
                    layer.close(index);
                    //此处请求后台程序，下方是成功后的前台处理……
                    fn_supplierOperate(3,data)
                    var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
                });

            }else{//查看字典值
                // layer.alert(data.id);
                 layer.open({
                     type: 2,
                     shade: 0.8,
                     title: '字典值列表', //不显示标题
                     area: ["80%", "90%"],
                     end: function () {//重新加载
                         window.parent.location.reload();
                     },
                     content: window.baseUrl+'/modules/dictionary/dictionaryValue.html?parentId='+data.id,
                     success: function(layero, index){

                     }
                 });

             }

        });
      var $ = layui.$;
        $('#addDic').on('click', function(){
            fn_supplierOperate(2)
        });


        function fn_supplierOperate(type,data){
            var	title = "";
             if(type==1){
                title="编辑";
            }else if(type==2){
                title="新增";
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

             if(type==1){
                $("#confirmBox input[name=dicName]").val(data.name);
                $("#confirmBox input[name=type]").val(data.type);
                $("#confirmBox input[name=remark]").val(data.remark);
                $("#confirmBox input[name=Id]").val(data.id);
                form.on('submit(saveDic)', function(data){
                    var  dicName= $("#confirmBox input[name=dicName]").val();
                    var  type= $("#confirmBox input[name=type]").val();
                    var  remark= $("#confirmBox input[name=remark]").val();
                    var  Id= $("#confirmBox input[name=Id]").val();
                    var _jsonFilter={
                        id:Id,
                        name:dicName,
                        type: type,
                        remark:remark
                    };
                    var formatedata =JSON.stringify(_jsonFilter);
                    //修改字典
                    $.ajax({
                        type: "POST",
                        url:dict_url.dict_edit,
                        contentType: "application/json",
                        data: formatedata,
                        success: function(r){
                            if(r.code == 0){
                                layer.alert("编辑成功",function () {
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
                $.ajax({ //删除
                    type: "POST",
                    url:dict_url.dict_delete+data.id,
                    contentType: "application/json",
                    success: function(r){
                        if(r.code == 0){
                            layer.msg("删除成功",function () {
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
                //点击确定事件
                 $("#confirmBox input").val("");
                form.on('submit(saveDic)', function(data){
                    var  dicName= $("#confirmBox input[name=dicName]").val();
                    var  type= $("#confirmBox input[name=type]").val();
                    var  remark= $("#confirmBox input[name=remark]").val();
                    var  Id= $("#confirmBox input[name=Id]").val();
                    var _jsonFilter={
                        id:Id,
                        name:dicName,
                        type: type,
                        remark:remark
                    };
                    var formatedata =JSON.stringify(_jsonFilter);
                    //新增品牌
                    $.ajax({
                        type: "POST",
                        url:dict_url.dict_add,
                        contentType: "application/json",
                        data: formatedata,
                        success: function(r){
                            if(r.code == 0){
                                layer.alert("新增成功",function () {
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

table.render({
            elem: '#DicTable',
            url:dict_url.dict_list,
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
                        field: 'name',
                        title: '字典名称'

                    }, {
                    field: 'type',
                    title: '字典类型'

                }, {
                    field: 'remark',
                    title: '备注',

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
            var dicName = $('#dicName');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        dicName: dicName.val()
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
