package com.hsl.clgl.sh.pc.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色与菜单对应关系
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@TableName("sh_role_menu")
public class ShRoleMenuEntity implements Serializable {
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
