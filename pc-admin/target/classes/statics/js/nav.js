var navs = [{
	"title": "会员管理",
	"href": "",
	"spread": false,
	"children": [{
			"title": "极差明细",
			"href": "jichaManage.html",
			"spread": false
		},
		{
			"title": "服务费明细",
			"href": "servicefeelist.html",
			"spread": false
		},
		{
			"title": "服务费转账",
			"href": "transfer.html",
			"spread": false
		}
	]
}, {
	"title": "接车单列表",
	"href": "",
	"spread": false,
	"children": [{
			"title": "积分明细",
			"href": "integrallist.html",
			"spread": false
		},
		{
			"title": "积分转账",
			"href": "transfer.html",
			"spread": false
		},
		{
			"title": "报单积分充值",
			"href": "invest.html",
			"spread": false
		}
	]
}, {
	"title": "事故单列表",
	"href": "",
	"spread": false,
	"children": [{
			"title": "申报明细",
			"href": "declarelist.html",
			"spread": false
		},
		{
			"title": "积分配票申请",
			"href": "declaresys.html",
			"spread": false
		},
		{
			"title": "服务费配票申请",
			"href": "declareserver.html",
			"spread": false
		}
	]
}, {
	"title": "维修单列表",
	"href": "",
	"spread": false,
	"children": [{
			"title": "维修单列表",
			"href": "info.html",
			"spread": false
		},
		{
			"title": "下料单",
			"href": "recommand.html",
			"spread": false
		},
		{
			"title": "库存列表",
			"href": "editpwd.html",
			"spread": false
		}
	]
}, {
	"title": "账号管理",
	"href": "",
	"spread": false,
	"children": [{
			"title": "角色管理",
			"href": "info.html",
			"spread": false
		},
		{
			"title": "部门管理",
			"href": "recommand.html",
			"spread": false
		},
		{
			"title": "用户管理",
			"href": "editpwd.html",
			"spread": false
		}
	]
}]



function initNav(data,contextPath) {
	var url = window.location.pathname;
	url = url.substring(url.lastIndexOf('/') + 1, url.length);
	for(var first in navs) {
		var level1 = navs[first]
		for(var second = 0; second < level1.children.length; second++) {
			if(level1.children[second].href == url) {
				level1.children[second].spread = true;
				level1.spread = true;
			};
		}
	}
	$(".layui-side-scroll").html(navBar(data,contextPath)).height($(window).height() - 230);
    $(window).resize(function(){
	$(".navBar").height($(window).height() - 230);
    })
}

function navBar(data,contextPath) {
	var ulHtml = '<ul class="layui-nav layui-nav-tree">';
	for(var i = 0; i < data.length; i++) {
		if(data[i].spread) {
			ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
		} else {
			ulHtml += '<li class="layui-nav-item">';
		}
		if(data[i].children != undefined && data[i].children.length > 0) {
			ulHtml += '<a href="javascript:;">';
			if(data[i].icon != undefined && data[i].icon != '') {
				if(data[i].icon.indexOf("icon-") != -1) {
					ulHtml += '<i class="iconfont ' + data[i].icon + '" data-icon="' + data[i].icon + '"></i>';
				} else {
					ulHtml += '<i class="layui-icon" data-icon="' + data[i].icon + '">' + data[i].icon + '</i>';
				}
			}
			ulHtml += '<cite>' + data[i].title + '</cite>';
			ulHtml += '<span class="layui-nav-more"></span>';
			ulHtml += '</a>'
			ulHtml += '<dl class="layui-nav-child">';
			for(var j = 0; j < data[i].children.length; j++) {
				if(data[i].children[j].spread) {
					ulHtml += '<dd class="layui-this"><a href="'+contextPath + data[i].children[j].href + '">';
				} else {
					ulHtml += '<dd><a href="'+contextPath + data[i].children[j].href + '">';
				}
				if(data[i].children[j].icon != undefined && data[i].children[j].icon != '') {
					if(data[i].children[j].icon.indexOf("icon-") != -1) {
						ulHtml += '<i class="iconfont ' + data[i].children[j].icon + '"data-icon="' + data[i].children[j].icon + '"></i>';
					} else {
						ulHtml += '<i class="layui-icon" data-icon="' + data[i].children[j].icon + '">' + data[i].children[j].icon + '</i>';
					}
				}
				ulHtml += '<cite>' + data[i].children[j].title + '</cite></a></dd>';
			}
			ulHtml += "</dl>"
		} else {
			ulHtml += '<a href="'+contextPath + data[i].href + '">';
			if(data[i].icon != undefined && data[i].icon != '') {
				if(data[i].icon.indexOf("icon-") != -1) {
					ulHtml += '<i class="iconfont ' + data[i].icon + '" data-icon="' + data[i].icon + '"></i>';
				} else {
					ulHtml += '<i class="layui-icon" data-icon="' + data[i].icon + '">' + data[i].icon + '</i>';
				}
			}
			ulHtml += '<cite>' + data[i].title + '</cite></a>';
		}
		ulHtml += '</li>'
	}
	ulHtml += '</ul>';
	return ulHtml;
}

// initNav(navs);//这一步是用来生成左侧导航的