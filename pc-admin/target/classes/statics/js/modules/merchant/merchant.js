var map;
var mouseTool;
var amapAdcode = {};
var delMenu;
//地图进入存储器
var mapData;
//标点储存器
var pointMarker;
$(function(){
    map = new AMap.Map('merchantMap2', {
        resizeEnable: true,
        zoom:11,
        center: [116.397428, 39.90923]
    });
    mouseTool = new AMap.MouseTool(map);
    delMenu = new AMap.ContextMenu();  //创建右键菜单
    //右键放大
    delMenu.addItem("删除绘图", function () {
        delMenu.callback();
    }, 0);
    //绘图监听事件
    AMap.event.addListener(mouseTool, "draw", function (e) {
        map.plugin(["AMap.PolyEditor"], function () {
            var p = e.obj;

            var editor = new AMap.PolyEditor(map, p);
            editor.open();
            p.editor = editor;

            rightClick(p, editor);
//            AMap.event.addListener(p, "rightclick", function (e) {
//                delMenu.callback = function () {
//
//              	  editor.close();
//              	  map.remove(p);
//              	  map.remove(editor);
//                };
//                delMenu.open(map, e.lnglat);
//			});


        });
        mouseTool.close();
        map.setFitView();//地图自适应
        map.setDefaultCursor("pointer");
    });
    fn_set_polygon_by_map();
});
//绘图事件各级辅助方法定义
function fn_set_polygon_by_map(){
    amapAdcode._district = new AMap.DistrictSearch({//高德行政区划查询插件实例
        subdistrict: 1   //设置需返回下一级行政区
    });
    //高德地图不提供街道商圈的独有编码和边界查询，故此方法搁浅
    amapAdcode._bizArea = new AMap.DistrictSearch({//高德行政区划查询插件实例
        subdistrict: 0  //设置需返回下一级行政区
    });
    amapAdcode._overlay = [];//行政区划覆盖物
    amapAdcode.createSelectList = function(selectId, list) {//生成下拉列表
        var selectList = document.getElementById(selectId);
        selectList.innerHTML = '';
        selectList.add(new Option('--请选择--'));
        for (var i = 0, l = list.length, option; i < l; i++) {
            option = new Option(list[i].name);
            option.setAttribute("value", list[i].adcode)
            selectList.add(option);
        }
    }
    amapAdcode.search = function(adcodeLevel, keyword, selectId) {//查询行政区划列表并生成相应的下拉列表
        var me = this;
        if (adcodeLevel == 'district'||adcodeLevel == 'city') {//第三级时查询边界点
            this._district.setExtensions('all');//返回行政区边界坐标组等具体信息
        } else {
            this._district.setExtensions('base');
        }
        this._district.setLevel(adcodeLevel); //行政区级别
        this._district.search(keyword, function(status, result) {//注意，api返回的格式不统一，在下面用三个条件分别处理

            var districtData = result.districtList[0];

            if (districtData.districtList) {
                me.createSelectList(selectId, districtData.districtList);
            } else if (districtData.districts) {
                me.createSelectList(selectId, districtData.districts);
            } else {
                document.getElementById(selectId).innerHTML = '';
            }
            //map.setCenter(districtData.center);

            me.clearMap();
            me.addPolygon(districtData.boundaries,districtData.level);
        });
    }
    //高德地图不提供街道商圈的独有编码和边界查询，故此方法搁浅
    amapAdcode.searchBizArea = function(adcodeLevel, keyword) {//查询行政区划列表并生成相应的下拉列表
        var me = this;
        this._bizArea.setExtensions('all');//返回行政区边界坐标组等具体信息

        this._bizArea.setLevel(adcodeLevel); //行政区级别
        this._bizArea.search(keyword, function(status, result) {//注意，api返回的格式不统一，在下面用三个条件分别处理

            var districtData = result.districtList[0];

            //map.setCenter(districtData.center);

            me.clearMap();
            me.addPolygon(districtData.boundaries,districtData.level);
        });
    }
    amapAdcode.clearMap = function(selectId) {//清空地图上的覆盖物
        map.remove(this._overlay);
        this._overlay = [];
    }
    amapAdcode.addPolygon = function(boundaries,level) {//往地图上添加覆盖物
        if (boundaries && (level=='district'||level=='city'||level=='biz_area')) {
            for (var i = 0, l = boundaries.length; i < l; i++) {
                //生成行政区划polygon
                var polygon = new AMap.Polygon({
                    //map: map,
                    path: boundaries[i],
                    strokeColor: "#71C671", //线颜色
                    strokeOpacity: 1, //线透明度
                    strokeWeight: 2,    //线宽
                    fillColor: "#E0FFFF", //填充色
                    fillOpacity: 0.35,//填充透明度
                    zIndex:0
                });
                this._overlay.push(polygon);
                polygon.setMap(map);

                AMap.event.addListener(polygon, "rightclick", function (e) {
                    contextMenu.callback = function () {
                        fn_clear_polygon();
                        for(var i =0;i<amapAdcode._overlay.length;i++){
                            var p = new AMap.Polygon({
                                path: amapAdcode._overlay[i].getPath(),//设置多边形边界路径
                                strokeColor: "#1791fc", //线颜色
                                strokeOpacity: 1, //线透明度
                                strokeWeight: 2,    //线宽
                                fillColor: "#1791fc", //填充色
                                fillOpacity: 0.35//填充透明度
                            });
                            p.setMap(map);

                            map.plugin(["AMap.PolyEditor"], function () {
                                var editor = new AMap.PolyEditor(map, p);
                                editor.open();
                                p.editor = editor;

                                AMap.event.addListener(p, "rightclick", function (e) {
                                    delMenu.callback = function () {
                                        editor.close();
                                        map.remove(p);
                                        map.remove(editor);
                                    };
                                    delMenu.open(map, e.lnglat);
                                });
                            });
                        }
                        map.setFitView();//地图自适应
                    };
                    contextMenu.open(map, e.lnglat);
                });
            }
//            map.setFitView();//地图自适应
        }
    }
    amapAdcode.clear = function(selectId) {//清空下拉列表
        var selectList = document.getElementById(selectId);
        selectList.innerHTML = '';
    }
    amapAdcode.createProvince = function() {//创建省列表
        this.search('country', '中国', 'provinces');
    }
    amapAdcode.createCity = function(provinceAdcode) {//创建市列表
        this.search('province', provinceAdcode, 'citys');
        this.clear('district');
        this.clear('biz_area');
    }
    amapAdcode.createDistrict = function(cityAdcode) {//创建区县列表
        this.search('city', cityAdcode, 'district');
        this.clear('biz_area');
    }
    amapAdcode.createBiz = function(districtAdcode) {//创建商圈列表
        this.search('district', districtAdcode, 'biz_area');
    }
    amapAdcode.createProvince();
    contextMenu = new AMap.ContextMenu();  //创建右键菜单
    contextMenu.addItem("设为绘图区域", function () {
        //mouseTool.polygon({path: contextMenu.curPolygon.getPath()});
        contextMenu.callback();
    }, 0);
}
function newMap(){
    map.setDefaultCursor("pointer")
    map.clearMap();
    $("#btn_group")[0].style.display='none';
    $("#btn_group2")[0].style.display='none';
    $("#tip")[0].style.display='none';
    // $("#biaoDian").attr('disabled',false);
    // $("#huiTu").attr('disabled',false);
    $("#huiTu")[0].style.display='block';
    $("#biaoDian")[0].style.display='block';
    // $("#save").attr('disabled',true);
    $("#save")[0].style.display='none';
    if(mapData.lngLat!=null&&mapData.lngLat!=''){
        var pointJson = JSON.parse(mapData.lngLat);
        var point = [pointJson.lng,pointJson.lat];
        map.setCenter(point);
        var detailMarker = new AMap.Marker({
            icon: "../../statics/img/point2.png",
            position: point
        });
        detailMarker.setMap(map);

    }
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。

}
function fn_clear_polygon(){

    // map.clearMap();
    $('#btn_show').show();
    $('#btn_hide').hide();
    newMap();
//                     if(row.lngLat!=null&&row.lngLat!=''){
//                         var pointJson = JSON.parse(row.lngLat);
//                         var point = [pointJson.lng,pointJson.lat];
//                         map.setCenter(point);
//                         var polygonMarker = new AMap.Marker({
//                             icon: "../image/point1.png",
//                             position: point
//                         });
//                         polygonMarker.setMap(map);
// //				    polygonMarker.setAnimation('AMAP_ANIMATION_BOUNCE');
//                     }

}
function rightClick(p,editor) {
    AMap.event.addListener(p, "rightclick", function (e) {
        delMenu.callback = function () {
            var polygons_old = map.getAllOverlays("polygon");
            var areasData_old = [];
            if(polygons_old.length>0){
                for (var i = 0; i < polygons_old.length; i++) {
                    if (polygons_old[i].editor == null)
                        continue;
                    var tmArea = polygons_old[i].getPath();
                    var areaData = [];
                    for (var j = 0; j < tmArea.length; j++) {
                        var tmpPoint = {};
                        tmpPoint["lat"] = tmArea[j]["lat"];
                        tmpPoint["lng"] = tmArea[j]["lng"];
                        areaData.push(tmpPoint);
                    }
                    areasData_old.push(areaData);
                }
            }

            editor.close();
            map.remove(p);
            map.remove(editor);
            var polygons = map.getAllOverlays("polygon");
            var areasData = [];
            if(polygons.length>0){
                for (var i = 0; i < polygons.length; i++) {
                    if (polygons[i].editor == null)
                        continue;
                    var tmArea = polygons[i].getPath();
                    var areaData = [];
                    for (var j = 0; j < tmArea.length; j++) {
                        var tmpPoint = {};
                        tmpPoint["lat"] = tmArea[j]["lat"];
                        tmpPoint["lng"] = tmArea[j]["lng"];
                        areaData.push(tmpPoint);
                    }
                    areasData.push(areaData);
                }
                // checkSpeicalCoverAjax(areasData, areasData_old)
            }else {
                // checkSpeicalCoverAjax("", areasData_old)
            }
        };
        delMenu.open(map, e.lnglat);
    });
}
layui.use(["element", "form", "table","layedit","upload", "laydate"], function() {
    element = layui.element,
        table = layui.table,
        form = layui.form,
        layedit = layui.layedit;
        upload = layui.upload;
        // layedit.build('detailedIntroduce'); //建立编辑器
        laydate = layui.laydate
    laydate.render({
        elem: '#beginTime',
        type: "date"
    });
    laydate.render({
        elem: '#endTime',
        type: "date"
    })
    var uploadInst = upload.render({
        elem: '.addMorePic' //绑定元素
        ,url: '/upload/' //上传接口
        ,done: function(res){
            //上传完毕回调
        }
        ,error: function(){
            //请求异常回调
        }
    });
    var $ = layui.$;
    $("#picContainer").on("click","b",function(){
        /*   layer.confirm("确认要删除吗?", { title: "删除确认" }, function (btnIndex) {
       console.log(btnIndex);
       if(btnIndex==1){
           $(this).parent().remove();
       }

   });  */
        var current=$(this);

        layer.confirm('确认删除？',

            {
                btn: ['确定','取消'] //按钮

            },
            function(index){
                current.parent().remove()

                layer.msg('删除成功', {icon: 1});
                return true;
            },
            function(index){
                layer.msg('已取消！', {icon: 1});
                return false;
            }
        );




    })
    form.render();
    // new_element=document.createElement("script");
    // new_element.setAttribute("type","text/javascript");
    // new_element.setAttribute("src","merchantDetails.js");// 在这里引入了merchantDetails.js
    // document.body.appendChild(new_element);

    //引入查看标志，为false则意味着查看状态下无需联动加载车系信息
    var detailFlag = false;
    //存储业务范围下拉值
    var allRepairType;
    //已选业务
    var selectRepairType;

    table.on('tool(merchantTable)', function(obj) {
        var data = obj.data;
        if(obj.event === 'detail') {
            // layer.msg('查看【' + data.brandName + ' 】品牌');
            fn_supplierOperate(0,data);
            detailFlag = true;
        } else if(obj.event === 'edit') {
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            fn_supplierOperate(1,data);//传值为1时是编辑操作，需要传送行数据用来更新表单
        }else if(obj.event === 'del'){//删除
            layer.confirm("确定删除商户名称为【"+data.merchantName +"】的记录？", {
                btn : [ '确定', '取消' ]//按钮
            }, function(index) {
                layer.close(index);
                //此处请求后台程序，下方是成功后的前台处理……
                fn_supplierOperate(3,data)
                var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2
            });

        }else if(obj.event === 'gis'){//切换到地图界面
            fn_supplierOperate(4,data);

        }

    });

    $('#addMerchant').on('click', function(){
        fn_supplierOperate(2);
    });
    $('#return').on('click', function(){
        returnPage();
    });
    $('#biaoDian').on('click', function(){
        biaoDian();
    });
    $('#huiTu').on('click', function(){
        huiTu();
    });
    $('#btn_show').on('click', function(){
        fn_show_around();
    });
    $('#btn_hide').on('click', function(){
        fn_hide_around();
    });
    $('#clear_point').on('click', function(){
        fn_remove_point();
    });
    $('#polygon_begin').on('click', function(){
        fn_polygon_begin();
    });
    $('#clear_polygon').on('click', function(){
        fn_clear_polygon();
    });
    $('#check_polygon').on('click', function(){
        fn_check_polygon('check');
    });
    $('#save').on('click', function(){
        if($("#biaoDian")[0].style.display == 'block'){
            var poinInfo = '';
            if(pointMarker){
                var pointInfo = '{"lng": '+pointMarker.getPosition()["lng"]+',"lat": '+pointMarker.getPosition()["lat"]+'}';
                fn_save_point(pointInfo);
            }else{
                layer.alert("没有任何标点，无法操作！");
            }
        }else if($("#huiTu")[0].style.display == 'block'){
            fn_check_polygon('save');
        }

    });
    $('#newMap').on('click', function(){
        newMap();
    });
    form.on('select(province)', function(data){
        // console.log(data.elem); //得到select原始DOM对象
        // console.log(data.value); //得到被选中的值
        loadCity(data.value,"city");
    });
    form.on('select(updateProvince)', function(data){
        // console.log(data.elem); //得到select原始DOM对象
        // console.log(data.value); //得到被选中的值
        if(detailFlag == false){
            loadCity(data.value,"updateCity");
        }
    });
    function returnPage(){
        $("#bodys")[0].style.display='block';
        $("#maps")[0].style.display='none';
        $("#btn_group")[0].style.display='none';
        $("#btn_group2")[0].style.display='none';
        $("#tip")[0].style.display='none';
        $('#btn_show').show();
        $('#btn_hide').hide();
        // $("#biaoDian").attr('disabled',false);
        // $("#huiTu").attr('disabled',false);
        $("#biaoDian")[0].style.display='block';
        $("#huiTu")[0].style.display='block';
        $("#save")[0].style.display='none';
        map.clearMap();
        map.setFitView();//地图自适应
        map.setDefaultCursor("pointer");
    }
    function fn_remove_point(){
        if(pointMarker){
            map.remove([pointMarker]);
            pointMarker = null;
        }
    }
    function biaoDian(){
        map.on('click', function(e) {
            fn_click_set_point(e);
        });
        $("#btn_group2")[0].style.display='block';
        // $("#huiTu").attr('disabled',true);
        $("#huiTu")[0].style.display='none';
        $("#save")[0].style.display='block';
        fn_load_point_page();
    }
    function huiTu(){
        $("#btn_group")[0].style.display='block';
        $("#tip")[0].style.display='block';
        // $("#biaoDian").attr('disabled',true);
        $("#biaoDian")[0].style.display='none';
        $("#save")[0].style.display='block';
        fn_load_polygon_page();
    }

    function fn_set_city(cityId){

        $("#citys option").each(function (){
            if($(this).val()==cityId){
                $(this).attr('selected',true);
            }
        });
//	$('#city').val(cityName);
    }
    function _fn_set_city(cityId)
    {
        return function()
        {
            fn_set_city(cityId);
        }
    }
    function fn_click_set_point(e){
        var point = [e.lnglat.getLng(),e.lnglat.getLat()];
        if(pointMarker){
            pointMarker.setPosition(point);
        }else{
            pointMarker = new AMap.Marker({
                icon: "../../statics/img/point2.png",
                position: point,
                draggable: true,
                cursor: 'move',
                raiseOnDrag: true
            });
            pointMarker.setMap(map);
        }
    }
    //标点主方法
    function fn_load_point_page(){
        map.clearMap();

        if(mapData.lngLat != null && mapData.lngLat != ''){
            var pointJson = JSON.parse(mapData.lngLat);
            var point = [pointJson.lng,pointJson.lat];
            map.setCenter(point);
            pointMarker = new AMap.Marker({
                icon: "../../statics/img/point2.png",
                position: point,
                draggable: true,
                cursor: 'move',
                raiseOnDrag: true
            });
            pointMarker.setMap(map);
        }

        if(mapData.allLatiLongi!=null&&mapData.allLatiLongi!=''&&mapData.allLatiLongi!='[]'){
            var polygonJson = JSON.parse(mapData.allLatiLongi);
            $(polygonJson).each(function(i,cm){
                var pathArr = new Array;
                $(cm).each(function(j,cmm){
                    pathArr.push([cmm["lng"], cmm["lat"]]);
                });
                var p = new AMap.Polygon({
                    path: pathArr,//设置多边形边界路径
                    strokeColor: "#fdc300", //线颜色
                    strokeOpacity: 1, //线透明度
                    strokeWeight: 2,    //线宽
                    fillColor: "#fdc300", //填充色
                    fillOpacity: 0.35//填充透明度
                });
                p.on('click',function(e){
                    fn_click_set_point(e);
                });
                p.setMap(map);
            });
        }
        if((mapData.lngLat==null||mapData.lngLat=='')&&(mapData.allLatiLongi==null||mapData.allLatiLongi==''||mapData.allLatiLongi=='[]')){
            pointMarker = null;
            var geocoder = new AMap.Geocoder({
                //city: "010", //城市，默认：“全国”
                radius: 1000 //范围，默认：500
            });
            //地理编码,返回地理编码结果
            geocoder.getLocation(mapData.provinceName+mapData.cityName+mapData.districtName, function(status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    var geocode = result.geocodes;
                    if(geocode[0]){
                        var point = [geocode[0].location.getLng(),  geocode[0].location.getLat()];
                        map.setCenter(point);
                    }
                }
            });
        }
        map.setFitView();
    }
    /**
     * 点击“绘图”，主事件触发方法
     * @param row
     */
    function fn_load_polygon_page(){
        map.clearMap();
        $("#provinces option").each(function (){

            if($(this).val()==mapData.provinceId){

                $(this).attr('selected',true);
            }
        });

        amapAdcode.createCity(mapData.provinceId);

        setTimeout(_fn_set_city(mapData.cityId),1000);
        amapAdcode.createDistrict(mapData.cityId);

        if(mapData.allLatiLongi != null && mapData.allLatiLongi != '' && mapData.allLatiLongi != '[]'){
            var polygonJson = JSON.parse(mapData.allLatiLongi);
            var zindex = 1;
            $(polygonJson).each(function(i,cm){

                if(zindex<10){
                    zindex++;
                }else{
                    zindex=10;
                }
                var pathArr = new Array;
                $(cm).each(function(j,cmm){
                    pathArr.push([cmm["lng"], cmm["lat"]]);
                });
                var p = new AMap.Polygon({
                    path: pathArr,//设置多边形边界路径
                    strokeColor: "#6A5ACD", //线颜色
                    strokeOpacity: 1, //线透明度
                    strokeWeight: 2,    //线宽
                    fillColor: "#6CA6CD", //填充色
                    fillOpacity: 0.6,//填充透明度
                    zIndex:zindex
                });
                p.setMap(map);
                var editor = new AMap.PolyEditor(map, p);
                editor.open();
                p.editor = editor;
                rightClick(p, editor);
                // orgRow = row;
//			AMap.event.addListener(p, "rightclick", function (e) {
//                delMenu.callback = function () {
//
//              	  editor.close();
//              	  map.remove(p);
//              	  map.remove(editor);
//                };
//                delMenu.open(map, e.lnglat);
//			});
            });
        }

        if(mapData.lngLat!=null&&mapData.lngLat!=''){
            var pointJson = JSON.parse(mapData.lngLat);
            var point = [pointJson.lng,pointJson.lat];
            map.setCenter(point);
            var polygonMarker = new AMap.Marker({
                icon: "../../statics/img/point2.png",
                position: point
            });
            polygonMarker.setMap(map);
            // polygonMarker.setAnimation('AMAP_ANIMATION_BOUNCE');
        }

        if((mapData.lngLat==null||mapData.lngLat=='')&&(mapData.allLatiLongi==null||mapData.allLatiLongi==''||mapData.allLatiLongi=='[]')){
            var geocoder = new AMap.Geocoder({
                //city: "010", //城市，默认：“全国”
                radius: 1000 //范围，默认：500
            });
            //地理编码,返回地理编码结果
            geocoder.getLocation(mapData.provinceName+mapData.cityName+mapData.districtName, function(status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    var geocode = result.geocodes;
                    if(geocode[0]){
                        var point = [geocode[0].location.getLng(),  geocode[0].location.getLat()];
                        map.setCenter(point);
                    }
                }
            });
        }
        map.setFitView();
    }
    function fn_save_point(pointInfo){
        $.ajax({
            url:merchant_url.merchant_savePoint,
            type:'post',
            data:{
                lngLat:pointInfo,
                merchantId:mapData.id
            },
            dataType:'json',
            error:function(){
                layer.alert("系统异常,请稍后尝试!");
            },
            success:function(r){
                layer.alert("保存成功！",function(){
                    if(r.msg=='success'){
                        returnPage();
                        window.parent.location.reload();
                        parent.layer.close();
                    }
                });
            }
        });
    }
    function resetPolygon(row){
        map.clearMap();
        var polygonJson = row;
        var zindex = 1;
        $(polygonJson).each(function(i,cm){

            if(zindex<10){
                zindex++;
            }else{
                zindex=10;
            }
            var pathArr = new Array;
            $(cm).each(function(j,cmm){
                pathArr.push([cmm["lng"], cmm["lat"]]);
            });
            console.log('pathArr');
            console.log(pathArr);
            var p = new AMap.Polygon({
                path: pathArr,//设置多边形边界路径
                strokeColor: "#e86e03", //线颜色
                strokeOpacity: 0.8, //线透明度
                strokeWeight: 2,    //线宽
                fillColor: "#e86e03", //填充色
                fillOpacity: 0.35,//填充透明度
                zIndex:zindex
            });
            p.setMap(map);
            var editor = new AMap.PolyEditor(map, p);
            editor.open();
            p.editor = editor;
            rightClick(p,editor);
            polygonMarker();
        });
    }
    /**
     * 开始绘制
     */
    function fn_polygon_begin(){
        mouseTool.polygon({
            strokeColor: "#6A5ACD", //线颜色
            strokeOpacity: 1, //线透明度
            strokeWeight: 2,    //线宽
            fillColor: "#6CA6CD", //填充色
            fillOpacity: 0.6,//填充透明度
            zIndex:10
        });
        map.setDefaultCursor("url('../../statics/img/pencil.png'), pointer");
    }

    var cfPolygon = [];
    var cfMarker = [];
    var chPolygon = [];
    var chMarker = [];
    var prPolygon = [];
    var prMarker = [];
    var alertStr = '';
    function sleep(numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
            now = new Date();
            if (now.getTime() > exitTime)    return;
        }
    }
    //采用jquery easyui loading css效果
    function ajaxLoading(){
        $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height(),'z-index':10}).appendTo("body");
        $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
    }
    function ajaxLoadEnd(){
        $(".datagrid-mask").remove();
        $(".datagrid-mask-msg").remove();
    }
    /**
     * 保存入口
     * @param ope_source
     */
    function fn_check_polygon(ope_source){
        ajaxLoading();
        // setTimeout('fn_check_polygon1(\''+ope_source+'\')',1000);
        fn_check_polygon1(ope_source);
    }
    /**
     * 绘图检测
     * @param ope_source
     */
    function fn_check_polygon1(ope_source){
        alertStr = '';
        map.remove(cfPolygon);
        map.remove(cfMarker);
        cfPolygon=[];
        cfMarker = [];

        map.remove(chPolygon);
        map.remove(chMarker);
        chPolygon=[];
        chMarker = [];

        map.remove(prPolygon);
        map.remove(prMarker);
        prPolygon=[];
        prMarker = [];

        var polygons = map.getAllOverlays("polygon");

        if(polygons.length==0){
            ajaxLoadEnd();
            layer.alert("没有任何绘图，无法操作！");
            return;
        }

        var areasData = [];
        for (var i = 0; i < polygons.length; i++) {
            if (polygons[i].editor == null)
                continue;
            var tmArea = polygons[i].getPath();
            var areaData = [];
            for (var j = 0; j < tmArea.length; j++) {
                var tmpPoint = {};
                tmpPoint["lat"] = tmArea[j]["lat"];
                tmpPoint["lng"] = tmArea[j]["lng"];
                if(j == tmArea.length-1) {
                    if((tmArea[j-1]["lat"] !=tmArea[j]["lat"]) ||  (tmArea[j-1]["lng"]!=tmArea[j]["lng"])) {
                        areaData.push(tmpPoint);
                    }
                }else {
                    areaData.push(tmpPoint);
                }
            }

            if(areaData.length>2){
                areasData.push(areaData);
            }
        }
        if(areasData.length==0){
            ajaxLoadEnd();
            layer.alert("没有任何绘图，无需校验！");
            return;
        }

        // var row  = $('#treegrid').treegrid('getSelections')[0];
        $.ajax({
            url:merchant_url.merchant_mapCheck,
            async: false,
            type:'post',
            data:{
                merchantId:mapData.id,
                allLatiLongi:JSON.stringify(areasData)
            },
            dataType:'json',
            error:function(){
                ajaxLoadEnd();
                layer.alert("系统异常,请稍后尝试！");
            },
            success:function(r){

                var jiaojiName = '';

                if(r.fmtPolygon!="" && r.fmtPolygon !=null){


                    map.clearMap();

                    var polygonJson = JSON.parse(r.fmtPolygon);
                    var zindex = 1;
                    $(polygonJson).each(function(i,cm){
                        if(zindex<10){
                            zindex++;
                        }else{
                            zindex=10;
                        }
                        var pathArr = new Array;
                        $(cm).each(function(j,cmm){
                            pathArr.push([cmm["lng"], cmm["lat"]]);
                        });
                        var p = new AMap.Polygon({
                            path: pathArr,//设置多边形边界路径
                            strokeColor: "#6A5ACD", //线颜色
                            strokeOpacity: 1, //线透明度
                            strokeWeight: 2,    //线宽
                            fillColor: "#6CA6CD", //填充色
                            fillOpacity: 0.6,//填充透明度
                            zIndex:zindex
                        });
                        p.setMap(map);
                        var editor = new AMap.PolyEditor(map, p);
                        editor.open();
                        p.editor = editor;
                        rightClick(p, editor);
//					AMap.event.addListener(p, "rightclick", function (e) {
//		                delMenu.callback = function () {
//
//		              	  editor.close();
//		              	  map.remove(p);
//		              	  map.remove(editor);
//		                };
//		                delMenu.open(map, e.lnglat);
//					});
                    });
                    if(r.jiaoji.length>0){
                        $(r.jiaoji).each(function(i,cm){
                            var polygonJson = JSON.parse(cm['allLatiLongi']);
                            $(polygonJson).each(function(i,cm){
                                var pathArr = new Array;
                                $(cm).each(function(j,cmm){
                                    pathArr.push([cmm["lng"], cmm["lat"]]);
                                });
                                var p = new AMap.Polygon({
                                    path: pathArr,//设置多边形边界路径
                                    strokeColor: "#CD0000", //线颜色
                                    strokeOpacity: 1, //线透明度
                                    strokeWeight: 2,    //线宽
                                    fillColor: "#CD2626", //填充色
                                    fillOpacity: 0.35//填充透明度
                                });
                                cfPolygon.push(p);
                                p.setMap(map);
                            });

                            if(cm["lngLat"]!='' && cm["lngLat"]!=null){
                                var point = JSON.parse(cm["lngLat"]);
                                var pos = [point["lng"], point["lat"]];
                                var marker = new AMap.Marker({
                                    icon: "../../statics/img/location.png",
                                    label:{
                                        content:cm["merchantName"],
                                        offset:new AMap.Pixel(0,30)
                                    },
                                    position: pos
                                });
                                cfMarker.push(marker);
                                marker.setMap(map);
                            }
                            jiaojiName+=cm["merchantName"]+"、";
                        });
                        jiaojiName = jiaojiName.substring(0,jiaojiName.length-1);
                    }
                }else{
                    alertStr+='您的绘图无法格式化，请检查!';
                }

                if(jiaojiName!=''){
                    alertStr+='您的绘图与：'+jiaojiName+'存在覆盖!';
                }


                if(alertStr==''){
                    if(ope_source!='save'){
                        layer.alert("绘图校验通过！");
                        // $.messager.show({
                        //     title:'提示',
                        //     msg:'校验通过',
                        //     showType:'show',
                        //     timeout:1000,
                        //     style:{
                        //         right:0, // 与左边界的距离
                        //         top:0 // 与顶部的距离
                        //     }
                        // });
                    }else{
                        fn_save_polygon(JSON.stringify(areasData));
                    }
                }else{
                    fn_hide_around();
                    layer.alert(alertStr);
                }
                ajaxLoadEnd();
            }
        });
    }
    /**
     * 保存绘图数据
     * @param polygonInfo
     */
    function fn_save_polygon(polygonInfo){
        ajaxLoading();
        $.ajax({
            url:merchant_url.merchant_polygonSave,
            type:'post',
            data:{
                allLatiLongi:polygonInfo,
                merchantId:mapData.id
            },
            dataType:'json',
            error:function(){
                ajaxLoadEnd();
                layer.alert("系统异常,请稍后尝试！");
            },
            success:function(r){
                ajaxLoadEnd();
                layer.alert("保存成功！",function(){
                    if(r.msg=='success'){
                        returnPage();
                        window.parent.location.reload();
                        parent.layer.close();
                    }
                });
            }
        });
    }
    var aroundPolygon = [];
    var aroundMarker = [];
    /**
     * 显示周边区域
     * 查询cityCode=当前城市下的快赔中心，把所有区域描绘成图
     */
    function fn_show_around(){

        map.remove(aroundPolygon);
        map.remove(aroundMarker);
        aroundPolygon=[];
        aroundMarker = [];
        $.ajax({
            url:merchant_url.merchant_queryByCityCode,
            async: false,
            type:'post',
            data:{
                merchantId:mapData.id,
                cityId:mapData.cityId
            },
            dataType:'json',
            error:function(){
                layer.alert("系统异常,请稍后尝试！");
            },
            success:function(r){

                if(r.list.length>0){
                    $(r.list).each(function(i,cm){
                        if(cm['allLatiLongi']){
                            var polygonJson = JSON.parse(cm['allLatiLongi']);
                            $(polygonJson).each(function(i,cm){
                                var pathArr = new Array;
                                $(cm).each(function(j,cmm){
                                    pathArr.push([cmm["lng"], cmm["lat"]]);
                                });
                                var p = new AMap.Polygon({
                                    path: pathArr,//设置多边形边界路径
                                    strokeColor: "#7A378B", //线颜色
                                    strokeOpacity: 0.9, //线透明度
                                    strokeWeight: 2,    //线宽
                                    fillColor: "#98F5FF", //填充色
                                    fillOpacity: 0.35,//填充透明度
                                    zIndex:1
                                });
                                aroundPolygon.push(p);
                                p.setMap(map);
                            });
                        }
                        if(cm["lngLat"]){
                            var point = JSON.parse(cm["lngLat"]);
                            var pos = [point["lng"], point["lat"]];
                            var marker = new AMap.Marker({
                                icon: "../../statics/img/location.png",
                                label:{
                                    content:cm["merchantName"],
                                    offset:new AMap.Pixel(0,30)
                                },
                                position: pos
                            });
                            aroundMarker.push(marker);
                            marker.setMap(map);
                        }
                    });
//				map.setFitView();
                    $('#btn_show').hide();
                    $('#btn_hide').show();
                }else{
                    layer.alert("周边不存在已绘图区域！");
                    // $.messager.show({
                    //     title:'提示',
                    //     msg:'周边不存在区域',
                    //     showType:'show',
                    //     timeout:1000,
                    //     style:{
                    //         right:0, // 与左边界的距离
                    //         top:0 // 与顶部的距离
                    //     }
                    // });
                }
            }
        });
    }

    /**
     * 影藏周边区域
     */
    function fn_hide_around(){
        map.remove(aroundPolygon);
        map.remove(aroundMarker);
        aroundPolygon=[];
        aroundMarker = [];
        $('#btn_show').show();
        $('#btn_hide').hide();
    }

    function polygonMarker() {
        if(mapData.lngLat!=null&&mapData.lngLat!=''){
            var pointJson = JSON.parse(mapData.lngLat);
            var point = [pointJson.lng,pointJson.lat];
            map.setCenter(point);
            var polygonMarker = new AMap.Marker({
                icon: "../../statics/img/point2.png",
                position: point
            });
            polygonMarker.setMap(map);
        }
    }

    function fn_supplierOperate(type,data){

        var	title = "";
        if(type==0){
            title="查看商户";
        }else if(type==1){
            title="编辑商户";
        }else if(type==2){
            title="新增商户";
        }
        if(type!=3 && type!=4){
            layer.open({
                type: 1,
                shade: 0.8,
                title: title, //不显示标题
                area: ["80%", "80%"],
                end: function () {//重新加载
                    clearInfoBox();
                    window.parent.location.reload();
                    detailFlag = false;
                    // loadTable(carTypeParam);
                },
                content: $('#infoBox')
            });
        }

        if(type==0){
            $("#confirmBox textarea[name=detailedIntroduce]").val(data.detailedIntroduce);
            $("#confirmBox input[name=endWorkTime]").val(data.endWorkTime);
            $("#confirmBox input[name=startWorkTime]").val(data.startWorkTime);
            $("#confirmBox input[name=updateAdress]").val(data.adress);
            $("#confirmBox input[name=updateId]").val(data.id);
            $("#confirmBox input[name=updateIntroduce]").val(data.introduce);
            $("#confirmBox input[name=updateManager]").val(data.manager);
            $("#confirmBox input[name=updateManagerPhone]").val(data.managerPhone);
            $("#confirmBox input[name=updateMerchantName]").val(data.merchantName);
            $("#confirmBox input[name=updateMerchantNo]").val(data.merchantNo);
            var obj = $("#confirmBox input[name=type]");
            for(var i = 0;i<obj.length;i++){
                if(obj[i].value == data.type){
                    obj[i].checked=true;
                }
            }
            if(data.lngLat != null && data.lngLat != ""){
                JSON.parse(data.lngLat, function (k, v) {
                    if(k == 'lng') {
                        $("#confirmBox input[name=lng]").val(v);
                    }
                    if(k == 'lat') {
                        $("#confirmBox input[name=lat]").val(v);
                    }
                })
            }
            $("#updateProvince").append('<option value="'+data.provinceId +'">'+ data.provinceName + '</option>');
            $('select[name="updateProvince"]').val(data.provinceId);
            $("#updateCity").append('<option value="'+data.cityId +'">'+ data.cityName + '</option>');
            $('select[name="updateCity"]').val(data.cityId);
            if(allRepairType ==null){
                loadRepairType("repairType");
            }else{
                $.each(allRepairType.allRepairType,function(key,values){
                    $("#repairType").append('<option value="'+values.repairTypeId +'">'+ values.repairTypeName + '</option>');
                });
            }
            loadSelectRepair(data.id,"repairType");
            // var repairTypesArr = [];
            // for(var i=0,len=selectRepairType.length; i<len; i++){
            //     repairTypesArr.push(selectRepairType[i].id);
            // }
            // repairTypesArr.push(repairTypesArr);
            // ($('select[name="repairType"]'))[0].val(repairTypesArr);
            // alert(($('select[name="repairType"]'))[0].vlaue);
            $("#confirmBox textarea[name=detailedIntroduce]").attr("readonly","readonly");
            $("#confirmBox input[name=endWorkTime]").attr("readonly","readonly");
            $("#confirmBox input[name=startWorkTime]").attr("readonly","readonly");
            $("#confirmBox input[name=updateAdress]").attr("readonly","readonly");
            $("#confirmBox input[name=updateId]").attr("readonly","readonly");
            $("#confirmBox input[name=updateIntroduce]").attr("readonly","readonly");
            $("#confirmBox input[name=updateManager]").attr("readonly","readonly");
            $("#confirmBox input[name=updateManagerPhone]").attr("readonly","readonly");
            $("#confirmBox input[name=updateMerchantName]").attr("readonly","readonly");
            $("#confirmBox input[name=updateMerchantNo]").attr("readonly","readonly");
            $("#confirmBox input[name=lng]").attr("readonly","readonly");
            $("#confirmBox input[name=lat]").attr("readonly","readonly");
            form.on('submit(saveMerchant)', function(data){
                clearInfoBox();
                window.location.reload();
                detailFlag = false;
                // loadTable(carTypeParam);
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });

        }else if(type==1){
            $("#confirmBox textarea[name=detailedIntroduce]").val(data.detailedIntroduce);
            $("#confirmBox input[name=endWorkTime]").val(data.endWorkTime);
            $("#confirmBox input[name=startWorkTime]").val(data.startWorkTime);
            $("#confirmBox input[name=updateAdress]").val(data.adress);
            $("#confirmBox input[name=updateId]").val(data.id);
            $("#confirmBox input[name=updateIntroduce]").val(data.introduce);
            $("#confirmBox input[name=updateManager]").val(data.manager);
            $("#confirmBox input[name=updateManagerPhone]").val(data.managerPhone);
            $("#confirmBox input[name=updateMerchantName]").val(data.merchantName);
            $("#confirmBox input[name=updateMerchantNo]").val(data.merchantNo);
            var obj = $("#confirmBox input[name=type]");
            for(var i = 0;i<obj.length;i++){
                if(obj[i].value == data.type){
                    obj[i].checked=true;
                }
            }
            if(data.lngLat != null && data.lngLat != ""){
                JSON.parse(data.lngLat, function (k, v) {
                    if(k == 'lng') {
                        $("#confirmBox input[name=lng]").val(v);
                    }
                    if(k == 'lat') {
                        $("#confirmBox input[name=lat]").val(v);
                    }
                })
            }
            $.ajax({//发送请求加载省份下拉框
                type:'POST',
                dataType:'json',
                url:area_url.province_list,
                success: function(data) {
                    if(data.code==0){
                        $("#updateProvince").append('<option value="">' + "请选择省份" + '</option>');
                        $.each(data.area,function(key,values){
                            $("#updateProvince").append('<option value="'+values.id +'">'+ values.name + '</option>');
                        });
                        form.render();

                    }

                }
            });
            $('select[name="updateProvince"]').val(data.provinceId);
            loadCity(data.provinceId,"updateCity");
            $('select[name="updateCity"]').val(data.cityId);
            if(allRepairType ==null){
                loadRepairType("repairType");
            }else{
                $.each(allRepairType.allRepairType,function(key,values){
                    $("#repairType").append('<option value="'+values.repairTypeId +'">'+ values.repairTypeName + '</option>');
                });
            }
            loadSelectRepair(data.id,"repairType");
            // $.ajax({//发送请求加载车辆品牌下拉框
            //     type:'POST',
            //     dataType:'json',
            //     url:car_brand_url.brand_select,
            //     success: function(data) {
            //         if(data.code==0){
            // $.each(carBrandData.brands,function(key,values){
            //     $("#updateCarBrand").append('<option value="'+values.brandId +'">'+ values.brandName + '</option>');
            // });

            //加载车系
            // loadTrain(brandId,"updateCarTrain");
            // $('select[name="updateCarBrand"]').val(brandId);
            // $('select[name="updateCarTrain"]').val(data.trainId);
            // form.render();

            //         }
            //
            //     }
            // });
            form.on('submit(saveMerchant)', function(data){
                var  detailedIntroduce= data.field.detailedIntroduce;
                var  endWorkTime= data.field.endWorkTime;
                var  repairType= data.field.repairType;//业务范围为array类型
                var  startWorkTime= data.field.startWorkTime;
                var  type= data.field.type;
                var  adress= data.field.updateAdress;
                var  lng= data.field.lng;
                var  lat= data.field.lat;
                var  cityId= data.field.updateCity;
                var  introduce= data.field.updateIntroduce;
                var  manager= data.field.updateManager;
                var  managerPhone= data.field.updateManagerPhone;
                var  merchantName= data.field.updateMerchantName;
                var  merchantNo= data.field.updateMerchantNo;
                var  province_id= data.field.updateProvince;
                var  merchantId = data.field.updateId;
                if(merchantName == null || merchantName == ''){
                    layer.alert('警告：商户名称为空！');
                    return;
                }
                if(merchantNo == null || merchantNo == ''){
                    layer.alert('警告：商户编号为空！');
                    return;
                }
                var _jsonFilter={
                    detailedIntroduce:detailedIntroduce,
                    endWorkTime:endWorkTime,
                    repairType:repairType,
                    startWorkTime:startWorkTime,
                    type: type,
                    lng: lng,
                    lat: lat,
                    adress:adress,
                    cityId:cityId,
                    introduce: introduce,
                    manager:manager,
                    managerPhone:managerPhone,
                    merchantName: merchantName,
                    merchantNo:merchantNo,
                    id:merchantId,
                    province_id:province_id
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //修改品牌
                $.ajax({
                    type: "POST",
                    url:merchant_url.merchant_update,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("编辑商户成功",function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });

                        }else{
                            layer.alert(r.msg,function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }else if(type==3){
            // title='删除车系';
            var jsonFilter={
                merchantId:data.id
            };
            var formatedata =JSON.stringify(jsonFilter);
            $.ajax({ //删除车系
                type: "POST",
                url:merchant_url.merchant_delete+data.id,
                contentType: "application/json",
                success: function(r){
                    if(r.code == 0){
                        layer.msg("删除商户成功",function () {
                            window.parent.location.reload();
                            parent.layer.close();
                            // loadTable(carTypeParam);
                        });
                    }else{
                        layer.msg(r.msg,function () {
                            window.parent.location.reload();
                            parent.layer.close();
                            // loadTable(carTypeParam);
                        });
                    }
                }
            });

        }else if(type==4){
          mapData =data;
          map.clearMap();
          if(data.type == 2){
              $("#huiTu")[0].style.display='none';
              $("#biaoDian")[0].style.display='block';
          }else if(data.type == 1){
              $("#huiTu")[0].style.display='block';
              $("#biaoDian")[0].style.display='block';

          }
            $("#bodys")[0].style.display='none';
            $("#maps")[0].style.display='block';

            var lng;//经度
            var lat;//纬度
            if(data.lngLat != null && data.lngLat != ""){
                JSON.parse(data.lngLat, function (k, v) {
                    if(k == 'lng') {
                        lng = v;
                    }
                    if(k == 'lat') {
                        lat = v;
                    }
                })
            }
            var point = [lng,lat];
            map.setCenter(point);
            var detailMarker = new AMap.Marker({
                icon: "../../statics/img/point2.png",
                position: point
            });
            detailMarker.setMap(map);
            detailMarker.setAnimation('AMAP_ANIMATION_BOUNCE');
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        }else{
            $.ajax({//发送请求加载省份下拉框
                type:'POST',
                dataType:'json',
                url:area_url.province_list,
                success: function(data) {
                    if(data.code==0){
                        $("#updateProvince").append('<option value="">' + "请选择省份" + '</option>');
                        $.each(data.area,function(key,values){
                            $("#updateProvince").append('<option value="'+values.id +'">'+ values.name + '</option>');
                        });
                        form.render();

                    }

                }
            });
            if(allRepairType ==null){
                loadRepairType("repairType");
            }else{
                $("#repairType").html('<option value="">' + "请选择业务" + '</option>');
                $.each(allRepairType.allRepairType,function(key,values){
                    $("#repairType").append('<option value="'+values.repairTypeId +'">'+ values.repairTypeName + '</option>');
                });
            }
            //点击确定事件
            form.on('submit(saveMerchant)', function(data){
                var  detailedIntroduce= data.field.detailedIntroduce;
                var  endWorkTime= data.field.endWorkTime;
                var  repairType= data.field.repairType;//业务范围为array类型
                var  startWorkTime= data.field.startWorkTime;
                var  type= data.field.type;
                var  adress= data.field.updateAdress;
                var  lng= data.field.lng;
                var  lat= data.field.lat;
                var  cityId= data.field.updateCity;
                var  introduce= data.field.updateIntroduce;
                var  manager= data.field.updateManager;
                var  managerPhone= data.field.updateManagerPhone;
                var  merchantName= data.field.updateMerchantName;
                var  merchantNo= data.field.updateMerchantNo;
                var  province_id= data.field.updateProvince;
                if(merchantName == null || merchantName == ''){
                    layer.alert('警告：商户名称为空！');
                    return;
                }
                if(merchantNo == null || merchantNo == ''){
                    layer.alert('警告：商户编号为空！');
                    return;
                }
                var _jsonFilter={
                    detailedIntroduce:detailedIntroduce,
                    endWorkTime:endWorkTime,
                    repairType:repairType,
                    startWorkTime:startWorkTime,
                    type: type,
                    lng: lng,
                    lat: lat,
                    adress:adress,
                    cityId:cityId,
                    introduce: introduce,
                    manager:manager,
                    managerPhone:managerPhone,
                    merchantName: merchantName,
                    merchantNo:merchantNo,
                    province_id:province_id
                };
                var formatedata =JSON.stringify(_jsonFilter);
                //新增车型
                $.ajax({
                    type: "POST",
                    url:merchant_url.merchant_save,
                    contentType: "application/json",
                    data: formatedata,
                    success: function(r){
                        if(r.code == 0){
                            layer.alert("新增商户成功",function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });
                        }else{
                            layer.alert(r.msg,function () {
                                clearInfoBox();
                                window.parent.location.reload();
                                parent.layer.close();
                                // loadTable(carTypeParam);
                            });
                        }
                    }
                });
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });
        }
        form.render();

    }


    $.ajax({//发送请求加载省份下拉框
        type:'POST',
        dataType:'json',
        url:area_url.province_list,
        success: function(data) {
            if(data.code==0){
                $.each(data.area,function(key,values){
                    $("#province").append('<option value="'+values.id +'">'+ values.name + '</option>');
                });
                form.render();

            }

        }
    });
    //加载地市下拉框
    function loadCity(id,selectId){
        var jsonFilter={
            id:id
        };
        var formatedata =JSON.stringify(jsonFilter);
        $.ajax({//发送请求加载车系下拉框
            type:'POST',
            dataType:'json',
            url:area_url.city_list+id,
            async: false,
            success: function(data) {
                if(data.code==0){
                    $("#"+selectId).html('<option value="">' + "请选择地市" + '</option>');
                    $.each(data.area,function(key,values){
                        $("#"+selectId).append('<option value="'+values.id +'">'+ values.name + '</option>');
                    });
                    form.render();

                }

            }
        });
    }
    //加载所选业务下拉框
    function loadSelectRepair(id,selectId){
        var jsonFilter={
            merchantId:id
        };
        var formatedata =JSON.stringify(jsonFilter);
        $.ajax({//发送请求加载车系下拉框
            type:'POST',
            dataType:'json',
            url:merchant_url.merchant_repair_type+id,
            async: false,
            success: function(data) {
                if(data.code==0){
                    var objre=$("#"+selectId)[0];
                    $.each(data.repairs,function(key,values){
                        for(var i=0,len=objre.length; i<len; i++){
                            if(objre[i].value==values.repairTypeId){
                                objre[i].selected = true;
                            }
                        }
                    });
                    form.render();
                }

            }
        });
    }
    //发送请求加载业务范围下拉框
    function loadRepairType(selectId){
        $.ajax({
            type:'POST',
            dataType:'json',
            url:repair_type_url.type_all,
            async: false,
            success: function(data) {
                if(data.code==0){
                    $("#"+selectId).html('<option value="">' + "请选择业务" + '</option>');
                    $.each(data.allRepairType,function(key,values){
                        $("#"+selectId).append('<option value="'+values.repairTypeId +'">'+ values.repairTypeName + '</option>');
                    });
                    allRepairType = data;
                    form.render();

                }

            }
        });
    }
    function clearInfoBox(){
        $("#confirmBox textarea[name=detailedIntroduce]").val("");
        $("#confirmBox input[name=endWorkTime]").val("");
        $("#confirmBox input[name=startWorkTime]").val("");
        $("#confirmBox input[name=updateAdress]").val("");
        $("#confirmBox input[name=updateId]").val("");
        $("#confirmBox input[name=updateIntroduce]").val("");
        $("#confirmBox input[name=updateManager]").val("");
        $("#confirmBox input[name=updateManagerPhone]").val(null);
        $("#confirmBox input[name=updateMerchantName]").val("");
        $("#confirmBox input[name=updateMerchantNo]").val("");
        $("#confirmBox input[name=lng]").val(null);
        $("#confirmBox input[name=lat]").val(null);

        $("#confirmBox textarea[name=detailedIntroduce]").removeAttr("readonly");
        $("#confirmBox input[name=endWorkTime]").removeAttr("readonly");
        $("#confirmBox input[name=startWorkTime]").removeAttr("readonly");
        $("#confirmBox input[name=updateAdress]").removeAttr("readonly");
        $("#confirmBox input[name=updateId]").removeAttr("readonly");
        $("#confirmBox input[name=updateIntroduce]").removeAttr("readonly");
        $("#confirmBox input[name=updateManager]").removeAttr("readonly");
        $("#confirmBox input[name=updateManagerPhone]").removeAttr("readonly");
        $("#confirmBox input[name=updateMerchantName]").removeAttr("readonly");
        $("#confirmBox input[name=updateMerchantNo]").removeAttr("readonly");
        $("#confirmBox input[name=lng]").removeAttr("readonly");
        $("#confirmBox input[name=lat]").removeAttr("readonly");
        $("#repairType").html('<option value="">' + "请选择业务" + '</option>');
        $("#updateProvince").html('<option value="">' + "请选择省份" + '</option>');
        $("#updateCity").html('<option value="">' + "请选择地市" + '</option>');
    }
    //恢复查询
    // function loadTable(carTypeParam){
    //     if(carTypeParam.flag == true){
    //         $('select[name="carBrand"]').val(carTypeParam.carBrand);
    //         $('select[name="carTrain"]').val(carTypeParam.carTrain);
    //         $('input[name="typeName"]').val(carTypeParam.typeName);
    //         table.reload('testReload', {
    //             page: {
    //                 curr: 1 //重新从第 1 页开始
    //             }
    //             ,where: {
    //                 key: {
    //                     carBrand: carTypeParam.carBrand,
    //                     carTrain: carTypeParam.carTrain,
    //                     typeName: carTypeParam.typeName
    //                 }
    //             }
    //         });
    //     }
    // }
    table.render({
        elem: '#merchantTable',
        url:merchant_url.merchant_list,
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
                    field: 'merchantNo',
                    title: '编号',
                    width:90,
                    minWidth:70

                }, {
                field: 'merchantName',
                title: '商户名称',
                width:130,
                minWidth:100

            },{
                field: 'manager',
                title: '负责人',
                width:90,
                minWidth:70

            },{
                field: 'managerPhone',
                title: '手机号码',
                width:100,
                minWidth:90

            },{
                field: 'createTime',
                title: '创建时间',
                width:110,
                minWidth:80

            },{
                field: 'provinceName',
                title: '省',
                width:90,
                minWidth:80

            },{
                field: 'cityName',
                title: '市',
                width:90,
                minWidth:80

            },{
                field: 'districtName',
                title: '区',
                width:80,
                minWidth:80

            },{
                field: 'adress',
                title: '详细地址',
                minWidth:150

            },{
                field: 'typeName',
                title: '类型',
                width:120,
                minWidth:80

            }, {
                fixed: 'right',
                title: "操作",
                width: 210,
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
            //打开存储开关
            // carTypeParam.flag = true;
            var merchantName = $('#merchantName').val();
            var type = $('#type').val();
            var beginTime = $('#beginTime').val();
            var endTime = $('#endTime').val();
            var province = $('#province').val();
            var city = $('#city').val();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        merchantName: merchantName,
                        type: type,
                        beginTime: beginTime,
                        endTime: endTime,
                        province: province,
                        city: city
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
