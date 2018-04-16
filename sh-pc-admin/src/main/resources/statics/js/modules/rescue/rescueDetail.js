/**
 * 救援单详情
 * Created by zhangqiao on 2018/4/9.
 */


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
var rescueId= Request["rescueId"];


function setDiv(item){
    var div = '<div class="layui-col-md12">'
        + item.createTime
        //+ '&nbsp;&nbsp;'
        + item.logRemark
        + '</div> '
    return div
}

layui.use(["element", "form", "table", "laydate", "layer"], function() {

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

    form.render()

    $.ajax({//查询救援单信息
        type: "POST",
        url:rescue_order_url.rescue_info+rescueId,
        contentType: "application/json",
        success: function(r){
            if(r.code == 0){
           console.log(r.shRescueOrderInfo);
           $("#rescueId").html(rescueId);
           $("#rescueTypeName").html(r.shRescueOrderInfo.rescueTypeName);
           $("#rescueRemark").html(r.shRescueOrderInfo.rescueRemark);
           $("#rescueAdress").html(r.shRescueOrderInfo.rescueAdress);
           $("#rescueCarNo").html(r.shRescueOrderInfo.rescueCarNo);
           $("#rescuePerson").html(r.shRescueOrderInfo.rescuePerson);
           $("#rescuePhone").html(r.shRescueOrderInfo.rescuePhone);
           //是否需要拖车
          var isNeedTrailer= r.shRescueOrderInfo.isNeedTrailer;
          var NeedTrailer;
          if(isNeedTrailer==1){
              NeedTrailer="需要";
          }else{
              NeedTrailer="不需要" ;
          }
          $("#trailerListStatus").html(NeedTrailer);
          //拖车状态
           var trailerListStatus = r.shRescueOrderInfo.trailerListStatus;
          //需要拖车的情况  需要等平台运营管理后台派完拖车完成后(状态为1时)  才能接单 此时把按钮都置灰
          if(typeof trailerListStatus === "undefined"&&1==isNeedTrailer){
              $("#jdBtn").attr("disabled",true);
              $("#wcBtn").attr("disabled",true);
          }

                if(1==isNeedTrailer&&trailerListStatus==0){
                    $("#jdBtn").attr("disabled",true);
                    $("#wcBtn").attr("disabled",true);
                }

         //救援单状态
         var  rescueStatus=r.shRescueOrderInfo.rescueStatus;
                //救援状态为 3：已接单、4:救援中、5:已完成、6:已评价   时 置灰不能点击
        if("3"==rescueStatus||"4"==rescueStatus||"5"==rescueStatus||"6"==rescueStatus){
            //接单按钮置灰
            $("#jdBtn").attr("disabled",true);

        }
            //2：已派单、3：已接单、5:已完成、6:已评价 时置灰不能点击
                if("2"==rescueStatus||"3"==rescueStatus||"5"==rescueStatus||"6"==rescueStatus){
                    //完成按钮置灰
                    $("#wcBtn").attr("disabled",true);

                }

                $.ajax({//发送请求加载日志list
                    type:'POST',
                    dataType:'json',
                    url:rescue_log_url.log_list+rescueId,
                    success: function(data) {
                        if(data.code==0){
                            console.log(data.rescueLogList)
                            //日志展示
                            $.each(data.rescueLogList,function(key,values){
                                $("#trailerLogList").append('<div class="layui-col-md12">' + values.createTime
                                    +'&nbsp;&nbsp;&nbsp;&nbsp;'+ values.logRemark+ '</div>');
                            });

                            //救援节点状态走向
                            $(".time_line li").each(function(index, item) {

                                $.each(data.rescueLogList,function(key,values){

                                     if(index+1==values.rescueStatus){
                                         $(item).addClass("active");
                                        $(item).find("div").eq(1).html(values.createTime);

                                     }
                                });

                            });

                            form.render();
                        }else{
                            layer.msg(r.msg,function () {
                                window.location.reload();
                            });
                        }

                    }
                });


            }else{
                layer.msg(r.msg,function () {
                    window.location.reload();
                   // parent.layer.close();
                });
            }
        }
    });

  //点击接单按钮
    $("#jdBtn").click(function(){
        //按钮置灰 防止重复提交
        $("#jdBtn").attr("disabled",true);
        var _jsonFilter={
            rescueId:rescueId,
            rescueStatus: 4

        };
        var formatedata =JSON.stringify(_jsonFilter);
        $.ajax({//接单
            type:'POST',
            contentType: "application/json",
            data: formatedata,
            url:rescue_order_url.rescue_receive,
            success: function(data) {
                if(data.code==0){
                    layer.alert("接单成功！",function () {
                        window.location.reload();
                        //$("#jdBtn").attr("disabled",true);
                    });


                }else{//失败

                }

            }
        });


    });

//点击完成按钮
    $("#wcBtn").click(function(){
        //按钮置灰 防止重复提交
        $("#wcBtn").attr("disabled",true);
        var _jsonFilter={
            rescueId:rescueId,
            rescueStatus: 5

        };
        var formatedata =JSON.stringify(_jsonFilter);
        console.log(formatedata);
        $.ajax({//接单
            type:'POST',
            contentType: "application/json",
            data: formatedata,
            url:rescue_order_url.rescue_receive,
            success: function(data) {
                if(data.code==0){
                    layer.alert("完成！",function () {
                        window.location.reload();
                        //$("#jdBtn").attr("disabled",true);
                    });


                }else{//失败

                }

            }
        });


    });





    $(".picList").on("click", ".smallPic", function() {
        document.getElementById("picContainer").style.backgroundImage = this.style.backgroundImage;
        layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            area: ['800px','600px'],
            shadeClose: true,
            skin: 'yourclass',
            isOutAnim: true,
            content: document.getElementById("bigPic").innerHTML
        });

    })

})