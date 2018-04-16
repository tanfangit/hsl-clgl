package com.hsl.clgl.pc.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-27 12:48:09
 */
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 角色ID
	 */
	private String roleId;
	/**
	 * 菜单ID
	 */
	private String menuId;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色ID
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：菜单ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：菜单ID
	 */
	public String getMenuId() {
		return menuId;
	}
}
