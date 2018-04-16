package com.hsl.clgl.pc.admin.modules.sys.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单管理
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-22 15:25:03
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单Id
	 */
	@TableId(type = IdType.INPUT)
	private String menuId;
	/**
	 * 父菜单ID，一级菜单为0
	 */
	private String parentId;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单URL
	 */
	@JSONField(name = "href")
	private String url;
	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	private String perms;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
	 */
	private Integer type;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 排序
	 */
	private Integer orderNum;

	/**
	 * 子菜单
	 */
	@TableField(exist=false)
	@JSONField(name = "children")
	//private List<?> list;

	private List<SysMenuEntity> list;
	/**
       配合前段layui组件需要的字段
	 */
	@TableField(exist=false)
	private boolean spread;

	/**
	 *  配合前段layui组件-用于选中勾选菜单
	 */
	@TableField(exist=false)
	private boolean checked;

	@TableField(exist=false)
	private  List<SysMenuEntity> data;


	public List<SysMenuEntity> getData() {
		return data;
	}

	public void setData(List<SysMenuEntity> data) {
		this.data = data;
	}

	/**
	 * 设置：
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 设置：父菜单ID，一级菜单为0
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父菜单ID，一级菜单为0
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：菜单URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：菜单URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}
	/**
	 * 获取：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPerms() {
		return perms;
	}
	/**
	 * 设置：类型   0：目录   1：菜单   2：按钮
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：目录   1：菜单   2：按钮
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：菜单图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}


	public List<SysMenuEntity> getList() {
		return list;
	}

	public void setList(List<SysMenuEntity> list) {
		this.list = list;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String toString() {
		return JSONObject.toJSONString(this);
	}


	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
