
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
//获取get请求里的参数
var Request = new Object();
Request = GetRequest();
var val= Request["parentId"];


layui.use(["form","table"], function() {
    var form = layui.form;
    var table = layui.table;


    table.render({
        elem: '#ValueTable',
        url:dict_value_url.dict_list,
        height: 320,
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
                    title: '字典值名称'

                }, {
                field: 'code',
                title: '字典码'

            }, {
                field: 'value',
                title: '字典值',

            },{
                field: 'remark',
                title: '备注',

            },{
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
        limits: [10 ,20, 40,80],
        where:{
            //自定义传参
            parentId:val
        }
    });

    table.on('tool(ValueTable)', function(obj) {
        var data = obj.data;
        if(obj.event === 'edit') {//编辑
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
        }else if(obj.event === 'del'){//删除
            layer.confirm("确定删除【"+data.name +"】的记录？", {
                btn : [ '确定', '取消' ]//按钮
            }, function(index) {
                layer.close(index);
                //此处请求后台程序，下方是成功后的前台处理……
                fn_supplierOperate(3,data)
                var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
            });

        }else if(obj.event === 'add'){//新增
            fn_supplierOperate(2,data);
        }

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
                    location.reload();
                },
                content: $('#infoBox')
            });
        }

        if(type==1){//编辑
            $("#confirmBox input[name=id]").val(data.id);
            $("#confirmBox input[name=parentId]").val(data.parentId);
            $("#confirmBox input[name=valueName]").val(data.name);
            $("#confirmBox input[name=code]").val(data.code);
            $("#confirmBox input[name=value]").val(data.value);
            $("#confirmBox input[name=order_num]").val(data.orderNum);
            $("#confirmBox input[name=remark]").val(data.remark);
            var delFlag = data.delFlag;
            form.on('submit(saveDicValue)', function(data){
                var  id= $("#confirmBox input[name=id]").val();
                var  parentId= $("#confirmBox input[name=parentId]").val();
                var  valueName= $("#confirmBox input[name=valueName]").val();
                var  code= $("#confirmBox input[name=code]").val();
                var  value= $("#confirmBox input[name=value]").val();
                var  order_num= $("#confirmBox input[name=order_num]").val();
                var  remark= $("#confirmBox input[name=remark]").val();
                var _jsonFilter={
                    id:id,
                    parentId:parentId,
                    name:valueName,
                    code:code,
                    value:value,
                    remark:remark,
                    orderNum:order_num,
                    delFlag:delFlag
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改字典
                $.ajax({
                    type: "POST",
                    url:dict_value_url.dict_edit,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("编辑成功",function () {
                                location.reload();
                                parent.layer.close();
                            });

                        }else{
                            layer.alert(r.msg,function () {
                                location.reload();
                                parent.layer.close();
                            });
                        }
                    },complete:function () {
                        form.render();
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else if(type==2){//新增
            $("#confirmBox input").val("");
            /*var orderNum = data.orderNum;
            var delFlag = data.delFlag;*/
            form.on('submit(saveDicValue)', function(data){
                var  id= $("#confirmBox input[name=id]").val();
                var  valueName= $("#confirmBox input[name=valueName]").val();
                var  code= $("#confirmBox input[name=code]").val();
                var  value= $("#confirmBox input[name=value]").val();
                var  order_num= $("#confirmBox input[name=order_num]").val();
                var  remark= $("#confirmBox input[name=remark]").val();
                var _jsonFilter={
                    id:id,
                    parentId:val,
                    name:valueName,
                    code:code,
                    value:value,
                    remark:remark,
                    orderNum:order_num,
                    delFlag:delFlag
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //新增字典
                $.ajax({
                    type: "POST",
                    url:dict_value_url.dict_add,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增成功",function () {
                                location.reload();
                                parent.layer.close();
                            });

                        }else{
                            layer.alert(r.msg,function () {
                                location.reload();
                                parent.layer.close();
                            });
                        }
                    },complete:function () {
                        form.render();
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });

        }else if(type==3){
            $.ajax({ //删除
                type: "POST",
                url:dict_value_url.dict_delete+data.id,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除成功",function () {
                            location.reload();
                            parent.layer.close();
                        });
                    }else{
                        layer.msg(r.msg,function () {
                            location.reload();
                            parent.layer.close();
                        });
                    }
                }
            });

        }
        form.render();

    }
    $('#addDicValue').on('click', function(){
        fn_supplierOperate(2)
    });

    //校验数据库中是否有重复的名称
    $("#valueName").change(function(){
        var  valueName= $("#confirmBox input[name=valueName]").val();
        $.ajax({
            type: "POST",
            url:dict_value_url.dict_list,
            contentType: "application/json",
            success: function(r){
                if(r.code == 0){
                    for(var i=0;i<r.rows.length;i++){
                        if(val==r.rows[i].parentId){
                            if(valueName==r.rows[i].name){layer.msg("该名称已存在")}
                        }
                    }
                }else{
                    layer.alert(r.msg,function () {
                        location.reload();
                        parent.layer.close();
                    });
                }
            },complete:function () {
                form.render();
            }
        });
    });

    //校验数据库中是否有重复的字典码
    $("#code").change(function(){
        var  code= $("#confirmBox input[name=code]").val();
        $.ajax({
            type: "POST",
            url:dict_value_url.dict_list,
            contentType: "application/json",
            success: function(r){
                if(r.code == 0){
                    for(var i=0;i<r.rows.length;i++){
                        if(val==r.rows[i].parentId){
                            if(code==r.rows[i].code){layer.msg("该字典码已存在")}
                        }
                    }
                }else{
                    layer.alert(r.msg,function () {
                        location.reload();
                        parent.layer.close();
                    });
                }
            },complete:function () {
                form.render();
            }
        });
    });

    //校验数据库中是否有重复的字典值
    $("#value").change(function(){
        var  value= $("#confirmBox input[name=value]").val();
        $.ajax({
            type: "POST",
            url:dict_value_url.dict_list,
            contentType: "application/json",
            success: function(r){
                if(r.code == 0){
                    for(var i=0;i<r.rows.length;i++){
                        if(val==r.rows[i].parentId){
                            if(value==r.rows[i].value){layer.msg("该字典值已存在")}
                        }
                    }
                }else{
                    layer.alert(r.msg,function () {
                        location.reload();
                        parent.layer.close();
                    });
                }
            },complete:function () {
                form.render();
            }
        });
    });
})